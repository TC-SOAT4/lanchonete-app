package com.fiap.lanchoneteapp.application.pedido.usecases;

import com.fiap.lanchoneteapp.application.pedido.gateways.PedidoGateway;
import com.fiap.lanchoneteapp.infrastructure.pedido.controllers.dto.PedidoListaDTO;

import java.util.Comparator;
import java.util.List;

public class ListarPedidos {

    private final PedidoGateway pedidoGateway;

    public ListarPedidos(PedidoGateway pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }

    public List<PedidoListaDTO> listarPedidos() {
        var lista = pedidoGateway.listarPedidos().stream().map(pedido -> new PedidoListaDTO(pedido)).toList();

        return lista.stream()
                .filter(p -> !p.getStatusPedido().equals("Finalizado"))
                .sorted(Comparator.comparingInt(p -> getStatusOrder(p.getStatusPedido())))
                .sorted(Comparator.comparing(p -> p.getDataHoraPedido()))
                .toList();
    }

    private int getStatusOrder(String status) {
        switch (status.toLowerCase()) {
            case "pronto":
                return 0;
            case "em preparação":
                return 1;
            case "recebido":
                return 2;
            default:
                return 3;
        }
    }

}
