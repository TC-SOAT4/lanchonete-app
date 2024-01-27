package com.fiap.lanchoneteapp.infrastructure.pedido.controllers.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fiap.lanchoneteapp.domain.pedido.entity.Pedido;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class PedidoPagoDTO {

    private Integer codigoPedido;
    private boolean pedidoPago;

    public PedidoPagoDTO(Pedido pedido) {
        this.codigoPedido = pedido.getIdPedido();
        this.pedidoPago = false;
    }

}
