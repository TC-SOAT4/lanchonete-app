package com.fiap.lanchoneteapp.domain.pedido.entity;

import com.fiap.lanchoneteapp.infrastructure.pedido.persistence.entity.StatusPagamentoEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StatusPagamento {

    private Integer idStatusPagamento;

    private String descricao;

    public StatusPagamento(StatusPagamentoEntity statusPagamentoEntity) {
        this.idStatusPagamento = statusPagamentoEntity.getIdStatusPagamento();
        this.descricao = statusPagamentoEntity.getDescricao();
    }

}
