package com.fiap.lanchoneteapp.application.pedido.usecases;

import com.fiap.lanchoneteapp.application.pedido.gateways.PedidoGateway;
import com.fiap.lanchoneteapp.domain.pedido.entity.Pedido;
import com.fiap.lanchoneteapp.infrastructure.pedido.controllers.dto.ResumoPedidoDTO;

public class BuscarPedidoPorId {

    private final PedidoGateway pedidoGateway;

    public BuscarPedidoPorId(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }

    public ResumoPedidoDTO buscarPorId(Integer id) {
        Pedido pedido =  this.pedidoGateway.buscarPorId(id);
        return new ResumoPedidoDTO(pedido);
    }
}
