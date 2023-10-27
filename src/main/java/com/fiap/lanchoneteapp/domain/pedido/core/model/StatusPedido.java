package com.fiap.lanchoneteapp.domain.pedido.core.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "StatusPedido")
public class StatusPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idStatusPedido;

    private String descricao;

}
