package com.fiap.lanchoneteapp.domain.pedido.entity;

import com.fiap.lanchoneteapp.infrastructure.pedido.persistence.entity.StatusPedidoEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StatusPedido {

    private Integer idStatusPedido;

    private String descricao;

    public StatusPedido(StatusPedidoEntity statusPedidoEntity) {
        this.idStatusPedido = statusPedidoEntity.getIdStatusPedido();
        this.descricao = statusPedidoEntity.getDescricao();
    }

}
