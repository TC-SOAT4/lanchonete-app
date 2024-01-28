package com.fiap.lanchoneteapp.infrastructure.pedido.controllers;

import com.fiap.lanchoneteapp.application.pedido.usecases.*;
import com.fiap.lanchoneteapp.infrastructure.pedido.controllers.dto.NovoPedidoDTO;
import com.fiap.lanchoneteapp.infrastructure.pedido.controllers.dto.PedidoListaDTO;
import com.fiap.lanchoneteapp.infrastructure.pedido.controllers.dto.PedidoPagoDTO;
import com.fiap.lanchoneteapp.infrastructure.pedido.controllers.dto.ResumoPedidoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Pedidos")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final RealizarCheckout realizarCheckout;

    private final ListarPedidos listarPedidos;

    private final BuscarPedidoPorId buscarPedidoPorId;

    private final BuscarStatusPagamentoPorId buscarStatusPagamentoPorId;

    private final AtualizarStatusPedido atualizarStatusPedido;

    private final AtualizarStatusPagamento atualizarStatusPagamento;

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

    @GetMapping("/{id}")
    @Operation(summary = "Buscar", description = "Buscar")
    public ResponseEntity<ResumoPedidoDTO> buscar(@PathVariable Integer id) {
        return ResponseEntity.ok().body(buscarPedidoPorId.buscarPorId(id));
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Atualizar status", description = "Atualizar status pedido")
    public ResponseEntity<Void> atualizarStatusPedido(@PathVariable Integer id, @RequestParam String novoStatus) {
        atualizarStatusPedido.atualizarStatusPedido(id, novoStatus);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}/status-pagamento")
    @Operation(summary = "Buscar Status Pagamento", description = "Consultar se o pedido está pago")
    public ResponseEntity<PedidoPagoDTO> obterStatusPagamento(@PathVariable Integer id) {
        PedidoPagoDTO pedidoPagoDTO = buscarStatusPagamentoPorId.buscarStatusPagamentoPorId(id);

        return ResponseEntity.ok().body(pedidoPagoDTO);
    }

    @PostMapping("/{id}/atualizar-status-pagamento")
    @Operation(summary = "Webhook - Atualizar Status pagamento", description = "Webhook para atualizar status do pagamento pedido")
    public ResponseEntity<String> atualizarStatusPagamento(@PathVariable Integer id, @RequestBody String statusPagamento) {
        atualizarStatusPagamento.atualizarStatusPagamento(id, statusPagamento);

        return ResponseEntity.ok().body("Infomração de pagamento recebida com sucesso para o id " + id);
    }
    
}

 