package com.fiap.lanchoneteapp.domain.pedido.core.ports.incoming;

import java.util.List;

import com.fiap.lanchoneteapp.domain.pedido.core.dto.PedidoListaDTO;

public interface IListarPedidos {

    public List<PedidoListaDTO> listarPadidos();
}
