package com.fiap.lanchoneteapp.domain.produto.infrastructure.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.lanchoneteapp.domain.produto.core.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    public List<Produto> findAllByCategoriaIdCategoria(Integer idCategoria);

}
