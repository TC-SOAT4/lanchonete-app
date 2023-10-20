package com.fiap.lanchoneteapp.domain.cliente.core.dto;

import com.fiap.lanchoneteapp.domain.cliente.core.model.Cliente;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponseDTO {

    private Integer idCliente;
    private String nome;
    private String cpf;

    
    public ClienteResponseDTO(Cliente cliente){
        this.idCliente = cliente.getIdCliente();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
    }
}
