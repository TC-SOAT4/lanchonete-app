package com.fiap.lanchoneteapp.application.cliente.usecases;

import com.fiap.lanchoneteapp.application.cliente.gateways.ClienteGateway;
import com.fiap.lanchoneteapp.domain.cliente.entity.Cliente;
import com.fiap.lanchoneteapp.infrastructure.cliente.controllers.dto.ClienteResponseDTO;

public class BuscarClientePorCpf {

    private final ClienteGateway clienteGateway;

    public BuscarClientePorCpf(ClienteGateway clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    public ClienteResponseDTO buscarPorCpf(String cpf){
        Cliente cliente = clienteGateway.buscarPorCpf(cpf);
        return new ClienteResponseDTO(cliente);
    };
}
