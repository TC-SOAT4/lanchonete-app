package com.fiap.lanchoneteapp.application.pedido.gateways;

import java.util.List;

import com.fiap.lanchoneteapp.domain.pedido.entity.Pedido;

public interface PedidoGateway {

    public List<Pedido> listarPedidos();

    public Pedido checkout(Pedido pedido);

}
