package com.fiap.lanchoneteapp.domain.produto.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.lanchoneteapp.domain.produto.core.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
