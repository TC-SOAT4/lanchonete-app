package com.fiap.lanchoneteapp.domain.produto.core.model;

import jakarta.persistence.Entity;
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
@Table(name = "Categoria")
public class Categoria {

    private Integer idCategoria;
    private String nome;
    private Boolean ativo;

}
