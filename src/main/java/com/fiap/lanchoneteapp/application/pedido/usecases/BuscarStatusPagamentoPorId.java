package com.fiap.lanchoneteapp.application.pedido.usecases;

import com.fiap.lanchoneteapp.application.pedido.gateways.PedidoGateway;
import com.fiap.lanchoneteapp.domain.pedido.entity.Pedido;
import com.fiap.lanchoneteapp.infrastructure.pedido.controllers.dto.PedidoPagoDTO;

public class BuscarStatusPagamentoPorId {

    private final PedidoGateway pedidoGateway;

    public BuscarStatusPagamentoPorId(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }

    public PedidoPagoDTO buscarStatusPagamentoPorId(Integer id) {
        Pedido pedido =  this.pedidoGateway.buscarPorId(id);

        PedidoPagoDTO pedidoPago = new PedidoPagoDTO(pedido);

        pedidoPago.setPedidoPago(pedido.getStatusPagamento().getDescricao().equals("Aprovado"));

        return pedidoPago;
    }
}
