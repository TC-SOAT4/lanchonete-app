package com.fiap.lanchoneteapp.domain.cliente.core.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CadastroClienteRequestDTO {

    @NotBlank
    private String nome;

    @NotBlank
    @Size(min=11)
    private String cpf;
    
}
