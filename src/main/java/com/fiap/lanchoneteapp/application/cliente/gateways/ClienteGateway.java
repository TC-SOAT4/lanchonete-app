package com.fiap.lanchoneteapp.application.cliente.gateways;

import com.fiap.lanchoneteapp.domain.cliente.entity.Cliente;

public interface ClienteGateway {

    public Cliente buscarPorCpf(String cpf);

    public Cliente cadatrarCliente(Cliente cliente);
}
