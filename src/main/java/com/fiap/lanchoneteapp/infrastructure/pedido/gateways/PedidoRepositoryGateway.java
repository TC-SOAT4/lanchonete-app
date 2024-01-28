package com.fiap.lanchoneteapp.infrastructure.pedido.gateways;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;

import com.fiap.lanchoneteapp.application.cliente.usecases.BuscarClientePorCpf;
import com.fiap.lanchoneteapp.application.pedido.gateways.PedidoGateway;
import com.fiap.lanchoneteapp.application.produto.usecases.BuscarProdutoPorCodigo;
import com.fiap.lanchoneteapp.domain.pedido.entity.Item;
import com.fiap.lanchoneteapp.domain.pedido.entity.Pedido;
import com.fiap.lanchoneteapp.infrastructure.cliente.controllers.dto.ClienteResponseDTO;
import com.fiap.lanchoneteapp.infrastructure.cliente.persistence.entity.ClienteEntity;
import com.fiap.lanchoneteapp.infrastructure.pedido.persistence.entity.ItemEntity;
import com.fiap.lanchoneteapp.infrastructure.pedido.persistence.entity.PedidoEntity;
import com.fiap.lanchoneteapp.infrastructure.pedido.persistence.entity.StatusPagamentoEntity;
import com.fiap.lanchoneteapp.infrastructure.pedido.persistence.entity.StatusPedidoEntity;
import com.fiap.lanchoneteapp.infrastructure.pedido.persistence.repository.PedidoRepository;
import com.fiap.lanchoneteapp.infrastructure.pedido.persistence.repository.StatusPagamentoRepository;
import com.fiap.lanchoneteapp.infrastructure.pedido.persistence.repository.StatusPedidoRepository;
import com.fiap.lanchoneteapp.infrastructure.produto.controllers.dto.ProdutoResponse;
import com.fiap.lanchoneteapp.infrastructure.produto.persistence.entity.ProdutoEntity;

public class PedidoRepositoryGateway implements PedidoGateway {

    private final BuscarClientePorCpf buscarClientePorCpf;

    private final BuscarProdutoPorCodigo buscarProdutoPorCodigo;

    private final PedidoRepository pedidoRepository;

    private final StatusPedidoRepository statusPedidoRepository;

    private final StatusPagamentoRepository statusPagamentoRepository;

    public PedidoRepositoryGateway(BuscarClientePorCpf buscarClientePorCpf,
            BuscarProdutoPorCodigo buscarProdutoPorCodigo,
            PedidoRepository pedidoRepository,
            StatusPedidoRepository statusPedidoRepository, StatusPagamentoRepository statusPagamentoRepository) {
        this.buscarClientePorCpf = buscarClientePorCpf;
        this.buscarProdutoPorCodigo = buscarProdutoPorCodigo;
        this.pedidoRepository = pedidoRepository;
        this.statusPedidoRepository = statusPedidoRepository;
        this.statusPagamentoRepository = statusPagamentoRepository;
    }

    public static final Integer STATUS_PEDIDO_RECEBIDO = 1;
    public static final Integer STATUS_PAGAMENTO_AGUARDANDO = 1;

    @Override
    public List<Pedido> listarPedidos() {
        List<PedidoEntity> lista = pedidoRepository.findAll();
        return lista.stream().map(p -> new Pedido(p)).toList();
    }

    @Override
    public Pedido checkout(Pedido pedido) {
        PedidoEntity novoPedido = PedidoEntity.builder()
                .data(LocalDateTime.now())
                .statusPedido(StatusPedidoEntity.builder().idStatusPedido(STATUS_PEDIDO_RECEBIDO).build())
                .statusPagamento(StatusPagamentoEntity.builder().idStatusPagamento(STATUS_PAGAMENTO_AGUARDANDO).build())
                .build();

        if (pedido.getCliente() != null && pedido.getCliente().getCpf() != null
                && !pedido.getCliente().getCpf().isEmpty()) {
            ClienteEntity clienteEntity = buscarClientePorCPF(pedido.getCliente().getCpf());
            novoPedido.setCliente(clienteEntity);
        }

        List<ItemEntity> itens = montarListaDeItens(pedido.getItens());
        novoPedido.setItens(itens);
        novoPedido.setPedidoNosItens();

        BigDecimal valorTotalPedido = calcularValorTotalPedido(itens);
        novoPedido.setValorTotal(valorTotalPedido);

        novoPedido = pedidoRepository.save(novoPedido);
        return new Pedido(novoPedido);
    }

    private ClienteEntity buscarClientePorCPF(String cpf) {
        ClienteResponseDTO clienteDTO = buscarClientePorCpf.buscarPorCpf(cpf);
        return clienteDTO != null ? ClienteEntity.builder()
                .idCliente(clienteDTO.getIdCliente())
                .nome(clienteDTO.getNome())
                .build() : null;
    }

    private BigDecimal calcularValorTotalPedido(List<ItemEntity> itens) {
        return itens.stream().map(item -> {
            return item.getProduto().getValor().multiply(BigDecimal.valueOf(item.getQuantidade()));
        }).reduce(BigDecimal.ZERO, (totalPedido, valorTotalItem) -> totalPedido.add(valorTotalItem)).setScale(2,
                RoundingMode.HALF_UP);
    }

    private List<ItemEntity> montarListaDeItens(List<Item> itens) {
        return itens.stream().map(i -> {
            ProdutoResponse produtoDTO = buscarProdutoPorCodigo.buscarPorCodigo(i.getProduto().getIdProduto());
            ProdutoEntity produtoEntity = ProdutoEntity.builder()
                    .idProduto(produtoDTO.getIdProduto())
                    .nome(produtoDTO.getNome())
                    .valor(produtoDTO.getValor())
                    .build();

            return ItemEntity.builder()
                    .produto(produtoEntity)
                    .quantidade(i.getQuantidade())
                    .build();
        }).toList();
    }

    public Pedido buscarPorId(Integer id) {
        PedidoEntity pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado com o ID: " + id));

        return new Pedido(pedido);
    }

    @Override
    public void atualizarStatusPedido(Integer id, String novoStatus) {
        PedidoEntity pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado com o ID: " + id));

        StatusPedidoEntity statusPedido = statusPedidoRepository.findByDescricao(novoStatus)
                .orElseThrow(() -> new RuntimeException("Status do pedido inválido: " + novoStatus));

        pedido.setStatusPedido(statusPedido);

        pedidoRepository.save(pedido);
    }

    @Override
    public void atualizarStatusPagamento(Integer id, String status) {
        PedidoEntity pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado com o ID: " + id));

        StatusPagamentoEntity statusPagamento = statusPagamentoRepository.findByDescricao(status)
                .orElseThrow(() -> new RuntimeException("Status do pagamento do pedido inválido: " + status));

        pedido.setStatusPagamento(statusPagamento);

        pedidoRepository.save(pedido);
    }

}
