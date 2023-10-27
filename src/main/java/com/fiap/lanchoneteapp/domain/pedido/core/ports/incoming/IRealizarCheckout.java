package com.fiap.lanchoneteapp.domain.pedido.core.ports.incoming;

import com.fiap.lanchoneteapp.domain.pedido.core.dto.NovoPedidoDTO;
import com.fiap.lanchoneteapp.domain.pedido.core.dto.ResumoPedidoDTO;

public interface IRealizarCheckout {

    public ResumoPedidoDTO checkout(NovoPedidoDTO novoPedidoDTO);
}
