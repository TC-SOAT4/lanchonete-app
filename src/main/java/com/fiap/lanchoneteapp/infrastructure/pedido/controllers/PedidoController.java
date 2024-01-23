package com.fiap.lanchoneteapp.infrastructure.pedido.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.lanchoneteapp.application.pedido.usecases.ListarPedidos;
import com.fiap.lanchoneteapp.application.pedido.usecases.RealizarCheckout;
import com.fiap.lanchoneteapp.infrastructure.pedido.controllers.dto.NovoPedidoDTO;
import com.fiap.lanchoneteapp.infrastructure.pedido.controllers.dto.PedidoListaDTO;
import com.fiap.lanchoneteapp.infrastructure.pedido.controllers.dto.ResumoPedidoDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Tag(name = "Pedidos")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final RealizarCheckout realizarCheckout;

     private final ListarPedidos listarPedidos;

    @PostMapping("/checkout")
    @Operation(summary = "Realizar Checkout", description = "Enviar pedido para fila")
    public ResponseEntity<ResumoPedidoDTO> criarNovoPedido(
            @RequestBody @Valid NovoPedidoDTO novoPedidoDTO) {
        return ResponseEntity.ok().body(realizarCheckout.checkout(novoPedidoDTO));
    }

    @GetMapping
    @Operation(summary = "Listar", description = "Lista pedidos")
    public ResponseEntity< List<PedidoListaDTO>> listarPedidos() {
        return ResponseEntity.ok().body(listarPedidos.listarPedidos());
    }
    
}

 