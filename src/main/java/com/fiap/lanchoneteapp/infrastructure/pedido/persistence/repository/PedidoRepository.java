package com.fiap.lanchoneteapp.infrastructure.pedido.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.lanchoneteapp.infrastructure.pedido.persistence.entity.PedidoEntity;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Integer> {
    
}
