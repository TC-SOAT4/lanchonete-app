package com.fiap.lanchoneteapp.domain.cliente.entity;

import com.fiap.lanchoneteapp.infrastructure.cliente.persistence.entity.ClienteEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente {

    private Integer idCliente;

    private String nome;
    private String cpf;
    private Boolean ativo;

    public Cliente(ClienteEntity clienteEntity) {
        this.idCliente = clienteEntity.getIdCliente();
        this.nome = clienteEntity.getNome();
        this.cpf = clienteEntity.getCpf();
        this.ativo = clienteEntity.getAtivo();
    }

}
