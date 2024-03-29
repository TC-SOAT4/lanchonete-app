package com.fiap.lanchoneteapp.application.pedido.usecases;

import java.time.LocalDateTime;
import java.util.List;

import com.fiap.lanchoneteapp.application.pedido.gateways.PedidoGateway;
import com.fiap.lanchoneteapp.domain.cliente.entity.Cliente;
import com.fiap.lanchoneteapp.domain.pedido.entity.Item;
import com.fiap.lanchoneteapp.domain.pedido.entity.Pedido;
import com.fiap.lanchoneteapp.domain.pedido.entity.StatusPedido;
import com.fiap.lanchoneteapp.domain.produto.entity.Produto;
import com.fiap.lanchoneteapp.infrastructure.pedido.controllers.dto.ItemDTO;
import com.fiap.lanchoneteapp.infrastructure.pedido.controllers.dto.NovoPedidoDTO;
import com.fiap.lanchoneteapp.infrastructure.pedido.controllers.dto.ResumoPedidoDTO;

public class RealizarCheckout {

    public static final Integer STATUS_PEDIDO_RECEBIDO = 1;

    private final PedidoGateway pedidoGateway;

    public RealizarCheckout(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }

    public ResumoPedidoDTO checkout(NovoPedidoDTO novoPedidoDTO) {
      return checkout(novoPedidoDTO, null);
    }

    public ResumoPedidoDTO checkout(NovoPedidoDTO novoPedidoDTO, String cpf) {
        Pedido pedido = Pedido.builder()
                .data(LocalDateTime.now())
                .statusPedido(StatusPedido.builder().idStatusPedido(STATUS_PEDIDO_RECEBIDO).build())
                .itens(montarListaDeItens(novoPedidoDTO.getItens()))
                .cliente(cpf != null ? Cliente.builder().cpf(cpf).build() : null)
                .build();
        pedido = pedidoGateway.checkout(pedido);

        return new ResumoPedidoDTO(pedido);
    }

    private List<Item> montarListaDeItens(List<ItemDTO> itens) {
        return itens.stream().map(item -> 
             Item.builder().produto(Produto.builder().idProduto(item.getCodigoProduto()).build())
                    .quantidade(item.getQuantidade()).build()
        ).toList();
    }
}
