package com.fiap.lanchoneteapp.application.pedido.usecases;

import com.fiap.lanchoneteapp.application.pedido.gateways.PedidoGateway;

public class AtualizarStatusPagamento {

    private final PedidoGateway pedidoGateway;


    public AtualizarStatusPagamento(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }

    public void atualizarStatusPagamento(Integer id, String status) {
        pedidoGateway.atualizarStatusPagamento(id, status);
    }
}
