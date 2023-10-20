package com.fiap.lanchoneteapp.domain.cliente.application;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.lanchoneteapp.domain.cliente.core.dto.CadastroClienteRequestDTO;
import com.fiap.lanchoneteapp.domain.cliente.core.dto.ClienteResponseDTO;
import com.fiap.lanchoneteapp.domain.cliente.core.ports.incoming.IBuscarClientePorCpf;
import com.fiap.lanchoneteapp.domain.cliente.core.ports.incoming.ICadastrarCliente;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ICadastrarCliente cadastrarCliente;

    private final IBuscarClientePorCpf buscarClientePorCpf;

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> cadastrarNovoCliente(
            @RequestBody @Valid CadastroClienteRequestDTO cadastroClienteRequestDto) {
        return ResponseEntity.ok().body(cadastrarCliente.cadatrarCliente(cadastroClienteRequestDto));
    }

    @GetMapping("/buscar-por-cpf")
    public ResponseEntity<ClienteResponseDTO> buscarPorCpf(@RequestParam(name = "cpf", required = true) String cpf) {
        return ResponseEntity.ok().body(buscarClientePorCpf.buscarPorCpf(cpf));
    }

}
