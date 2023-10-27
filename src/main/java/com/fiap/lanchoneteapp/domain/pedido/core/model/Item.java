package com.fiap.lanchoneteapp.domain.pedido.core.model;

import java.math.BigDecimal;

import com.fiap.lanchoneteapp.domain.produto.core.model.Produto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "Item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idItem;

    @ManyToOne
    @JoinColumn(name = "produtoId")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "pedidoId")
    private Pedido pedido;

    private Integer quantidade;

}