package com.fiap.lanchoneteapp.domain.pedido.entity;

import com.fiap.lanchoneteapp.domain.produto.entity.Produto;
import com.fiap.lanchoneteapp.infrastructure.pedido.persistence.entity.ItemEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Item {

    private String idItem;

    private Produto produto;

    private Pedido pedido;

    private Integer quantidade;

    public Item(ItemEntity itemEntity) {
        this.idItem = itemEntity.getIdItem();
        this.produto = new Produto(itemEntity.getProduto());
        this.pedido = new Pedido(itemEntity.getPedido());
        this.quantidade = itemEntity.getQuantidade();
    }

}