package com.fiap.lanchoneteapp.application.pedido.gateways;

import java.util.List;

import com.fiap.lanchoneteapp.domain.pedido.entity.Pedido;

public interface PedidoGateway {

    public List<Pedido> listarPedidos();

    public Pedido checkout(Pedido pedido);

    public Pedido buscarPorId(Integer id);

    void atualizarStatusPedido(Integer id, String novoStatus);

    void atualizarStatusPagamento(Integer id, String status);
}
