package com.fiap.lanchoneteapp.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fiap.lanchoneteapp.application.cliente.usecases.BuscarClientePorCpf;
import com.fiap.lanchoneteapp.application.pedido.gateways.PedidoGateway;
import com.fiap.lanchoneteapp.application.pedido.usecases.ListarPedidos;
import com.fiap.lanchoneteapp.application.pedido.usecases.RealizarCheckout;
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
    PedidoGateway pedidoGateway(BuscarClientePorCpf buscarClientePorCpf,
            BuscarProdutoPorCodigo buscarProdutoPorCodigo, PedidoRepository pedidoRepository) {
        return new PedidoRepositoryGateway(buscarClientePorCpf, buscarProdutoPorCodigo, pedidoRepository);
    }

}
