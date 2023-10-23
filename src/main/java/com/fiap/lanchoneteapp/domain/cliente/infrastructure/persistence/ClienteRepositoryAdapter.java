package com.fiap.lanchoneteapp.domain.cliente.infrastructure.persistence;

import org.springframework.stereotype.Component;

import com.fiap.lanchoneteapp.domain.cliente.core.model.Cliente;
import com.fiap.lanchoneteapp.domain.cliente.core.ports.outgoing.IClientePortRepository;
import com.fiap.lanchoneteapp.domain.cliente.infrastructure.repository.ClienteRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class ClienteRepositoryAdapter implements IClientePortRepository {

    private final ClienteRepository clienteRepository;

    @Override
    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente buscarPorCpf(String cpf) {
         return clienteRepository.findByCpf(cpf);
    }
    
}
