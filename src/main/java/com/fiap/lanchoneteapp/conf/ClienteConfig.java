package com.fiap.lanchoneteapp.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.fiap.lanchoneteapp.application.cliente.gateways.ClienteGateway;
import com.fiap.lanchoneteapp.application.cliente.usecases.BuscarClientePorCpf;
import com.fiap.lanchoneteapp.application.cliente.usecases.CadastrarCliente;
import com.fiap.lanchoneteapp.application.cliente.usecases.CadastrarClientePeloToken;
import com.fiap.lanchoneteapp.application.cognito.clients.CognitoClient;
import com.fiap.lanchoneteapp.infrastructure.cliente.gateways.ClienteRepositoryGateway;
import com.fiap.lanchoneteapp.infrastructure.cliente.persistence.repository.ClienteRepository;
import com.fiap.lanchoneteapp.infrastructure.cognito.clients.CognitoRestClient;

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

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    CognitoClient cognitoClient(RestTemplate restTemplate) {
        return new CognitoRestClient(restTemplate);
    }

    @Bean
    CadastrarClientePeloToken cadastrarClientePeloToken(ClienteGateway clienteGateway, CognitoClient cognitoClient) {
        return new CadastrarClientePeloToken(clienteGateway, cognitoClient);
    }

}
