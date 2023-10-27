package com.fiap.lanchoneteapp.domain.pedido.infrastructure.persistence;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fiap.lanchoneteapp.domain.pedido.core.model.Pedido;
import com.fiap.lanchoneteapp.domain.pedido.core.ports.outgoing.IPedidoPortRepository;
import com.fiap.lanchoneteapp.domain.pedido.infrastructure.repository.PedidoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class PedidoRepositoryAdapter implements IPedidoPortRepository {
    
    private final PedidoRepository pedidoRepository;

    @Override
    public Pedido novoPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public List<Pedido> listar() {
       return pedidoRepository.findAll();
    }

}
