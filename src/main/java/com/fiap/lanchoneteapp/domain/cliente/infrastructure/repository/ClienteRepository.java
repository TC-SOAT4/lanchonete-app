package com.fiap.lanchoneteapp.domain.cliente.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fiap.lanchoneteapp.domain.cliente.core.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

    public Cliente findByCpf(String cpf);
    
}
