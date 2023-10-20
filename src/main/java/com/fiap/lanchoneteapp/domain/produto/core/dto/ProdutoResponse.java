package com.fiap.lanchoneteapp.domain.produto.core.dto;

import java.math.BigDecimal;

import com.fiap.lanchoneteapp.domain.produto.core.model.Categoria;

import lombok.Data;

@Data
public class ProdutoResponse {

    private Integer idProduto;
    private String nome;
    private String descricao;
    private BigDecimal valor;
    private Boolean ativo;

    private Categoria categoria;

}
