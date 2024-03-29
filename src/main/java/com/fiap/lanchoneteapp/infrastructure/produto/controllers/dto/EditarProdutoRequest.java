package com.fiap.lanchoneteapp.infrastructure.produto.controllers.dto;

import java.math.BigDecimal;

import com.fiap.lanchoneteapp.domain.produto.entity.Categoria;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EditarProdutoRequest {

    @NotNull
    private Integer idProduto;

    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;

    @NotNull
    private BigDecimal valor;

    @NotNull
    private Categoria categoria;

    @NotNull
    private Boolean ativo;
    
}
