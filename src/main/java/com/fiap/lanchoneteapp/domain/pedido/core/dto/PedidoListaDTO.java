package com.fiap.lanchoneteapp.domain.pedido.core.dto;

import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fiap.lanchoneteapp.domain.pedido.core.model.Pedido;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class PedidoListaDTO {

    private Integer codigoPedido;
    private Object nomeCliente;
    private String statusPedido;
    private String dataHoraPedido;

    public PedidoListaDTO(Pedido pedido) {
        this.codigoPedido = pedido.getIdPedido();
        this.statusPedido = pedido.getStatusPedido().getDescricao();
        this.nomeCliente = pedido.getCliente() != null ? pedido.getCliente().getNome() : null;
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM HH:mm");
        this.dataHoraPedido = pedido.getData().format(formatter);
    }
    
}
