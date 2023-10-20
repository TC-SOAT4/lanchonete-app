package com.fiap.lanchoneteapp.domain.cliente.core.ports.incoming;

import com.fiap.lanchoneteapp.domain.cliente.core.dto.ClienteResponseDTO;

public interface IBuscarClientePorCpf {
    
    public ClienteResponseDTO buscarPorCpf(String cpf);
}
