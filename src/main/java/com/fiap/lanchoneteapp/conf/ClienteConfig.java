package com.fiap.lanchoneteapp.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fiap.lanchoneteapp.application.cliente.gateways.ClienteGateway;
import com.fiap.lanchoneteapp.application.cliente.usecases.BuscarClientePorCpf;
import com.fiap.lanchoneteapp.application.cliente.usecases.CadastrarCliente;
import com.fiap.lanchoneteapp.infrastructure.cliente.gateways.ClienteRepositoryGateway;
import com.fiap.lanchoneteapp.infrastructure.cliente.persistence.repository.ClienteRepository;

@Configuration
public class ClienteConfig {

    @Bean
    BuscarClientePorCpf buscarClientePorCpf(ClienteGateway clienteGateway) {
        return new BuscarClientePorCpf(clienteGateway);
    }

    @Bean
    CadastrarCliente cadastrarCliente(ClienteGateway clienteGateway) {
        return new CadastrarCliente(clienteGateway);
    }

    @Bean
    ClienteGateway clienteGateway(ClienteRepository clienteRepository) {
        return new ClienteRepositoryGateway(clienteRepository);
    }

}
