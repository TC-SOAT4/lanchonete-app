package com.fiap.lanchoneteapp.application.cliente.usecases;

import com.fiap.lanchoneteapp.application.cliente.gateways.ClienteGateway;
import com.fiap.lanchoneteapp.domain.cliente.entity.Cliente;
import com.fiap.lanchoneteapp.infrastructure.cliente.controllers.dto.CadastroClienteRequestDTO;
import com.fiap.lanchoneteapp.infrastructure.cliente.controllers.dto.ClienteResponseDTO;

public class CadastrarCliente {

    private final ClienteGateway clienteGateway;

    public CadastrarCliente(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    public ClienteResponseDTO cadatrarCliente(CadastroClienteRequestDTO clienteCadastro) {

        Cliente cliente = Cliente.builder()
                .nome(clienteCadastro.getNome()).cpf(clienteCadastro.getCpf()).build();

        cliente = clienteGateway.cadatrarCliente(cliente);
        return new ClienteResponseDTO(cliente);
    }

}
