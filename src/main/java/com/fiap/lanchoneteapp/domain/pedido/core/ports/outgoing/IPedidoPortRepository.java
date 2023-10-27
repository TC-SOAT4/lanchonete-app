package com.fiap.lanchoneteapp.domain.pedido.core.ports.outgoing;

import java.util.List;

import com.fiap.lanchoneteapp.domain.pedido.core.model.Pedido;

public interface IPedidoPortRepository {

    public Pedido novoPedido(Pedido pedido);

    public List<Pedido> listar();

}
