package com.fiap.lanchoneteapp.application.produto.usecases;

import java.util.List;

import com.fiap.lanchoneteapp.application.produto.gateways.ProdutoGateway;
import com.fiap.lanchoneteapp.infrastructure.produto.controllers.dto.ProdutoResponse;

public class ListarTodoProdutos {

    private final ProdutoGateway produtoGateway;

    public ListarTodoProdutos(ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway;
    }

    public List<ProdutoResponse> listarTodos() {
        return produtoGateway.listarTodos().stream().map(prduto -> new ProdutoResponse(prduto)).toList();
    };
}
