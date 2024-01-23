package com.fiap.lanchoneteapp.infrastructure.cliente.gateways;

import com.fiap.lanchoneteapp.application.cliente.gateways.ClienteGateway;
import com.fiap.lanchoneteapp.domain.cliente.entity.Cliente;
import com.fiap.lanchoneteapp.infrastructure.cliente.persistence.entity.ClienteEntity;
import com.fiap.lanchoneteapp.infrastructure.cliente.persistence.repository.ClienteRepository;

public class ClienteRepositoryGateway implements ClienteGateway {

    private final ClienteRepository clienteRepository;

    public ClienteRepositoryGateway(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente cadatrarCliente(Cliente cliente) {
        ClienteEntity novoCliente = ClienteEntity.builder()
                .nome(cliente.getNome())
                .cpf(cliente.getCpf())
                .ativo(Boolean.TRUE)
                .build();

        novoCliente = clienteRepository.save(novoCliente);

        return new Cliente(novoCliente);
    }

    @Override
    public Cliente buscarPorCpf(String cpf) {
        ClienteEntity cliente = clienteRepository.findByCpf(cpf);
        return new Cliente(cliente);
    }

}
