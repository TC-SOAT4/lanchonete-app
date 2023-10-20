package com.fiap.lanchoneteapp.domain.produto.core.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CadastroProdutoRequest {

    @NotNull
    private Integer idProduto;

    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;

    @NotNull
    private BigDecimal valor;

    @NotNull
    private Integer categoria;
    
}
