package com.fiap.lanchoneteapp.conf;

import com.fiap.lanchoneteapp.application.pedido.usecases.*;
import com.fiap.lanchoneteapp.infrastructure.pedido.persistence.repository.StatusPedidoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fiap.lanchoneteapp.application.cliente.usecases.BuscarClientePorCpf;
import com.fiap.lanchoneteapp.application.pedido.gateways.PedidoGateway;
import com.fiap.lanchoneteapp.application.produto.usecases.BuscarProdutoPorCodigo;
import com.fiap.lanchoneteapp.infrastructure.pedido.gateways.PedidoRepositoryGateway;
import com.fiap.lanchoneteapp.infrastructure.pedido.persistence.repository.PedidoRepository;

@Configuration
public class PedidoConfig {

    @Bean
    RealizarCheckout realizarCheckout(PedidoGateway pedidoGateway) {
        return new RealizarCheckout(pedidoGateway);
    }

    @Bean
    ListarPedidos listarPedidos(PedidoGateway pedidoGateway) {
        return new ListarPedidos(pedidoGateway);
    }

    @Bean
    BuscarPedidoPorId buscarPedidoPorId(PedidoGateway pedidoGateway) {
        return new BuscarPedidoPorId(pedidoGateway);
    }

    @Bean
    AtualizarStatusPedido atualizarStatusPedido(PedidoGateway pedidoGateway) {
        return new AtualizarStatusPedido(pedidoGateway);
    }

    @Bean
    PedidoGateway pedidoGateway(BuscarClientePorCpf buscarClientePorCpf,
                                BuscarProdutoPorCodigo buscarProdutoPorCodigo,
                                PedidoRepository pedidoRepository,
                                StatusPedidoRepository statusPedidoRepository) {
        return new PedidoRepositoryGateway(buscarClientePorCpf, buscarProdutoPorCodigo, pedidoRepository, statusPedidoRepository);
    }

    @Bean
    AtualizarStatusPagamento atualizarStatusPagamento(PedidoGateway pedidoGateway) {
        return new AtualizarStatusPagamento(pedidoGateway);
    }

    @Bean
    BuscarStatusPagamentoPorId buscarStatusPagamentoPorId(PedidoGateway pedidoGateway) {
        return new BuscarStatusPagamentoPorId(pedidoGateway);
    }

}
