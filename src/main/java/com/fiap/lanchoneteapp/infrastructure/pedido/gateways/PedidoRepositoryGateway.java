package com.fiap.lanchoneteapp.infrastructure.pedido.gateways;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;

import com.fiap.lanchoneteapp.application.cliente.usecases.BuscarClientePorCpf;
import com.fiap.lanchoneteapp.application.pedido.gateways.PedidoGateway;
import com.fiap.lanchoneteapp.application.produto.usecases.BuscarProdutoPorCodigo;
import com.fiap.lanchoneteapp.domain.cliente.entity.Cliente;
import com.fiap.lanchoneteapp.domain.pedido.entity.Item;
import com.fiap.lanchoneteapp.domain.pedido.entity.Pedido;
import com.fiap.lanchoneteapp.infrastructure.cliente.controllers.dto.ClienteResponseDTO;
import com.fiap.lanchoneteapp.infrastructure.pedido.persistence.entity.ItemEntity;
import com.fiap.lanchoneteapp.infrastructure.pedido.persistence.entity.PedidoEntity;
import com.fiap.lanchoneteapp.infrastructure.pedido.persistence.entity.StatusPedidoEntity;
import com.fiap.lanchoneteapp.infrastructure.pedido.persistence.repository.PedidoRepository;
import com.fiap.lanchoneteapp.infrastructure.produto.controllers.dto.ProdutoResponse;
import com.fiap.lanchoneteapp.infrastructure.produto.persistence.entity.ProdutoEntity;

public class PedidoRepositoryGateway implements PedidoGateway {

    private final BuscarClientePorCpf buscarClientePorCpf;

    private final BuscarProdutoPorCodigo buscarProdutoPorCodigo;

    private final PedidoRepository pedidoRepository;

    public PedidoRepositoryGateway(BuscarClientePorCpf buscarClientePorCpf,
            BuscarProdutoPorCodigo buscarProdutoPorCodigo, PedidoRepository pedidoRepository) {
        this.buscarClientePorCpf = buscarClientePorCpf;
        this.buscarProdutoPorCodigo = buscarProdutoPorCodigo;
        this.pedidoRepository = pedidoRepository;
    }

    public static final Integer STATUS_PEDIDO_RECEBIDO = 1;

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
                .build();

        if (pedido.getCliente() != null && pedido.getCliente().getCpf() != null
                && !pedido.getCliente().getCpf().isEmpty()) {
            Cliente cliente = buscarClientePorCPF(pedido.getCliente().getCpf());
            pedido.setCliente(cliente);
        }

        List<ItemEntity> itens = montarListaDeItens(pedido.getItens());
        novoPedido.setItens(itens);
        novoPedido.setPedidoNosItens();

        BigDecimal valorTotalPedido = calcularValorTotalPedido(itens);
        novoPedido.setValorTotal(valorTotalPedido);

        novoPedido = pedidoRepository.save(novoPedido);
        return new Pedido(novoPedido);
    }

    private Cliente buscarClientePorCPF(String cpf) {
        ClienteResponseDTO clienteDTO = buscarClientePorCpf.buscarPorCpf(cpf);
        return Cliente.builder()
                .idCliente(clienteDTO.getIdCliente())
                .nome(clienteDTO.getNome())
                .build();
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

}
