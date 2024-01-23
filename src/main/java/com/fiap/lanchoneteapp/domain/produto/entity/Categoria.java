package com.fiap.lanchoneteapp.domain.produto.entity;

import com.fiap.lanchoneteapp.infrastructure.produto.persistence.entity.CategoriaEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Categoria {

    private Integer idCategoria;

    private String nome;
    private Boolean ativo;

    public Categoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Categoria(CategoriaEntity categoriaEntity) {
        this.idCategoria = categoriaEntity.getIdCategoria();
        this.nome = categoriaEntity.getNome();
        this.ativo = categoriaEntity.getAtivo();
    }

}
