package com.fiap.lanchoneteapp.infrastructure.produto.controllers.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CadastroProdutoRequest {

    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;

    @NotNull
    private BigDecimal valor;

    @NotNull
    private Integer codigoCategoria;
    
}
