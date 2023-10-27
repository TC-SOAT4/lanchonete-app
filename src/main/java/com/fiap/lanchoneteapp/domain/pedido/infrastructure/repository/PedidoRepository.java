package com.fiap.lanchoneteapp.domain.pedido.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.lanchoneteapp.domain.pedido.core.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    
}
