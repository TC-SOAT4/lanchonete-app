package com.fiap.lanchoneteapp.application.pedido.usecases;

import java.time.LocalDateTime;

import com.fiap.lanchoneteapp.application.pedido.gateways.PedidoGateway;
import com.fiap.lanchoneteapp.domain.pedido.entity.Pedido;
import com.fiap.lanchoneteapp.domain.pedido.entity.StatusPedido;
import com.fiap.lanchoneteapp.infrastructure.pedido.controllers.dto.NovoPedidoDTO;
import com.fiap.lanchoneteapp.infrastructure.pedido.controllers.dto.ResumoPedidoDTO;

public class RealizarCheckout {

    public static final Integer STATUS_PEDIDO_RECEBIDO = 1;

    private final PedidoGateway pedidoGateway;

    public RealizarCheckout(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }

    public ResumoPedidoDTO checkout(NovoPedidoDTO novoPedidoDTO) {
        Pedido pedido = Pedido.builder()
                .data(LocalDateTime.now())
                .statusPedido(StatusPedido.builder().idStatusPedido(STATUS_PEDIDO_RECEBIDO).build())
                .build();
        pedido = pedidoGateway.checkout(pedido);

        return new ResumoPedidoDTO(pedido);
    }
}
