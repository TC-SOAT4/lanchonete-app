package com.fiap.lanchoneteapp.domain.pedido.core.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fiap.lanchoneteapp.domain.cliente.core.dto.ClienteResponseDTO;
import com.fiap.lanchoneteapp.domain.cliente.core.model.Cliente;
import com.fiap.lanchoneteapp.domain.cliente.core.ports.incoming.IBuscarClientePorCpf;
import com.fiap.lanchoneteapp.domain.pedido.core.dto.ItemDTO;
import com.fiap.lanchoneteapp.domain.pedido.core.dto.NovoPedidoDTO;
import com.fiap.lanchoneteapp.domain.pedido.core.dto.PedidoListaDTO;
import com.fiap.lanchoneteapp.domain.pedido.core.dto.ResumoPedidoDTO;
import com.fiap.lanchoneteapp.domain.pedido.core.model.Item;
import com.fiap.lanchoneteapp.domain.pedido.core.model.Pedido;
import com.fiap.lanchoneteapp.domain.pedido.core.model.StatusPedido;
import com.fiap.lanchoneteapp.domain.pedido.core.ports.incoming.IListarPedidos;
import com.fiap.lanchoneteapp.domain.pedido.core.ports.incoming.IRealizarCheckout;
import com.fiap.lanchoneteapp.domain.pedido.core.ports.outgoing.IPedidoPortRepository;
import com.fiap.lanchoneteapp.domain.produto.core.dto.ProdutoResponse;
import com.fiap.lanchoneteapp.domain.produto.core.model.Produto;
import com.fiap.lanchoneteapp.domain.produto.core.ports.incoming.IBuscarProdutoPorCodigo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PedidoService implements IRealizarCheckout, IListarPedidos {

    private final IBuscarClientePorCpf iBuscarClientePorCpf;

    private final  IBuscarProdutoPorCodigo iBuscarProdutoPorCodigo;

    private final IPedidoPortRepository iPedidoPortRepository;

    public static final Integer STATUS_PEDIDO_RECEBIDO = 1;

    @Override
    public List<PedidoListaDTO> listarPadidos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarPadidos'");
    }

    @Override
    public ResumoPedidoDTO checkout(NovoPedidoDTO novoPedidoDTO) {

        StatusPedido statusRecebido = StatusPedido.builder().idStatusPedido(STATUS_PEDIDO_RECEBIDO).descricao("Recebido").build();

        Pedido pedido = Pedido.builder()
            .data(LocalDateTime.now())
            .statusPedido(statusRecebido)
            .build();

        if(novoPedidoDTO.getCpf() != null && !novoPedidoDTO.getCpf().isEmpty()){
        
            Cliente cliente = buscarClientePorCPF(novoPedidoDTO.getCpf());
            pedido.setCliente(cliente);
        }

        List<Item> itens = montarListaDeItens(novoPedidoDTO.getItens());
        pedido.setItens(itens);
        pedido.setPedidoNosItens();

        BigDecimal valorTotalPedido = calcularValorTotalPedido(itens);
        pedido.setValorTotal(valorTotalPedido);

       pedido = iPedidoPortRepository.novoPedido(pedido);
       return new ResumoPedidoDTO(pedido);
    }

    private Cliente buscarClientePorCPF(String cpf){
        ClienteResponseDTO clienteDTO = iBuscarClientePorCpf.buscarPorCpf(cpf);
        return Cliente.builder()
                        .idCliente(clienteDTO.getIdCliente())
                        .nome(clienteDTO.getNome())
                        .build();
    }

    private BigDecimal calcularValorTotalPedido(List<Item> itens) {
        return itens.stream().map(item  -> {
            return item.getProduto().getValor().multiply(BigDecimal.valueOf(item.getQuantidade()));
        }).reduce(BigDecimal.ZERO, (totalPedido, valorTotalItem) ->  totalPedido.add(valorTotalItem)).setScale(2, RoundingMode.HALF_UP);
    }

    private List<Item> montarListaDeItens(List<ItemDTO> itens){
       return itens.stream().map(itemDTO -> {
            ProdutoResponse produtoDTO = iBuscarProdutoPorCodigo.buscarPorCodigo(itemDTO.getCodigoProduto());
            Produto produto = Produto.builder()
                                .idProduto(produtoDTO.getIdProduto())
                                .nome(produtoDTO.getNome())
                                .valor(produtoDTO.getValor())
                                .build();

            return Item.builder()
                        .produto(produto)
                        .quantidade(itemDTO.getQuantidade())
                        .build();
        }).toList();
    }
    
}
