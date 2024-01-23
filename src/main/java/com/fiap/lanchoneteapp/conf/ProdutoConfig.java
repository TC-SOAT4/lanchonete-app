package com.fiap.lanchoneteapp.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fiap.lanchoneteapp.application.produto.gateways.ProdutoGateway;
import com.fiap.lanchoneteapp.application.produto.usecases.BuscarProdutoPorCodigo;
import com.fiap.lanchoneteapp.application.produto.usecases.BuscarProdutosPorCategoria;
import com.fiap.lanchoneteapp.application.produto.usecases.CriarProduto;
import com.fiap.lanchoneteapp.application.produto.usecases.EditarProduto;
import com.fiap.lanchoneteapp.application.produto.usecases.ListarTodoProdutos;
import com.fiap.lanchoneteapp.application.produto.usecases.RemoverProduto;
import com.fiap.lanchoneteapp.infrastructure.produto.gateways.ProdutoRepositoryGateway;
import com.fiap.lanchoneteapp.infrastructure.produto.persistence.repository.ProdutoRepository;

@Configuration
public class ProdutoConfig {

    @Bean
    BuscarProdutoPorCodigo buscarProdutoPorCodigo(ProdutoGateway produtoGateway) {
        return new BuscarProdutoPorCodigo(produtoGateway);
    }

    @Bean
    BuscarProdutosPorCategoria buscarProdutosPorCategoria(ProdutoGateway produtoGateway) {
        return new BuscarProdutosPorCategoria(produtoGateway);
    }

    @Bean
    CriarProduto criarProduto(ProdutoGateway produtoGateway) {
        return new CriarProduto(produtoGateway);
    }

    @Bean
    EditarProduto editarProduto(ProdutoGateway produtoGateway) {
        return new EditarProduto(produtoGateway);
    }

    @Bean
    ListarTodoProdutos listarTodoProdutos(ProdutoGateway produtoGateway) {
        return new ListarTodoProdutos(produtoGateway);
    }

    @Bean
    RemoverProduto removerProduto(ProdutoGateway produtoGateway) {
        return new RemoverProduto(produtoGateway);
    }

    @Bean
    ProdutoGateway produtoGateway(ProdutoRepository produtoRepository) {
        return new ProdutoRepositoryGateway(produtoRepository);
    }

}
