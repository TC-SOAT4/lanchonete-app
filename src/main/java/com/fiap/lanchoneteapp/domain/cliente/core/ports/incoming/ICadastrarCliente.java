package com.fiap.lanchoneteapp.domain.cliente.core.ports.incoming;

import com.fiap.lanchoneteapp.domain.cliente.core.dto.CadastroClienteRequestDTO;
import com.fiap.lanchoneteapp.domain.cliente.core.dto.ClienteResponseDTO;

public interface ICadastrarCliente {

    public ClienteResponseDTO cadatrarCliente(CadastroClienteRequestDTO cliente);
    
}
