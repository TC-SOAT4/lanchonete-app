package com.fiap.lanchoneteapp.domain.cliente.core.ports.outgoing;

import com.fiap.lanchoneteapp.domain.cliente.core.model.Cliente;

public interface IClientePortRepository {

    Cliente salvar(Cliente cliente);

    Cliente buscarPorCpf(String cpf);
    
}
