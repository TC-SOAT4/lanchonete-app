package com.fiap.lanchoneteapp.domain.cliente.core.service;

import org.springframework.stereotype.Service;

import com.fiap.lanchoneteapp.domain.cliente.core.dto.CadastroClienteRequestDTO;
import com.fiap.lanchoneteapp.domain.cliente.core.dto.ClienteResponseDTO;
import com.fiap.lanchoneteapp.domain.cliente.core.model.Cliente;
import com.fiap.lanchoneteapp.domain.cliente.core.ports.incoming.IBuscarClientePorCpf;
import com.fiap.lanchoneteapp.domain.cliente.core.ports.incoming.ICadastrarCliente;
import com.fiap.lanchoneteapp.domain.cliente.core.ports.outgoing.IClientePortRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ClienteService implements ICadastrarCliente, IBuscarClientePorCpf {

    private final IClientePortRepository clientePortRepository;

    @Override
    public ClienteResponseDTO cadatrarCliente(CadastroClienteRequestDTO cliente) {
        Cliente novoCliente = Cliente.builder()
                                    .nome(cliente.getNome())
                                    .cpf(cliente.getCpf())
                                    .ativo(Boolean.TRUE)
                                    .build();

        novoCliente = clientePortRepository.salvar(novoCliente);

        return new ClienteResponseDTO(novoCliente);
    }

    @Override
    public ClienteResponseDTO buscarPorCpf(String cpf) {
        Cliente cliente = clientePortRepository.buscarPorCpf(cpf);
        return new ClienteResponseDTO(cliente);
    }

}
