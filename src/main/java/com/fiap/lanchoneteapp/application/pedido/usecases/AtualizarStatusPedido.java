package com.fiap.lanchoneteapp.application.pedido.usecases;

import com.fiap.lanchoneteapp.application.pedido.gateways.PedidoGateway;

public class AtualizarStatusPedido {
    private final PedidoGateway pedidoGateway;

    public AtualizarStatusPedido(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }

    public void atualizarStatusPedido(Integer id, String novoStatus) {
        this.pedidoGateway.atualizarStatusPedido(id, novoStatus);
    }
}
