package com.fiap.lanchoneteapp.infrastructure.pedido.persistence.repository;

import com.fiap.lanchoneteapp.infrastructure.pedido.persistence.entity.PedidoEntity;
import com.fiap.lanchoneteapp.infrastructure.pedido.persistence.entity.StatusPedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatusPedidoRepository extends JpaRepository<StatusPedidoEntity, Integer> {

    public Optional<StatusPedidoEntity> findByDescricao(String descricao);
    
}
