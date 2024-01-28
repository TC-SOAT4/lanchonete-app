package com.fiap.lanchoneteapp.infrastructure.pedido.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.lanchoneteapp.infrastructure.pedido.persistence.entity.StatusPagamentoEntity;

public interface StatusPagamentoRepository extends JpaRepository<StatusPagamentoEntity, Integer> {

    public Optional<StatusPagamentoEntity> findByDescricao(String descricao);

}
