package com.fiap.lanchoneteapp.application.produto.usecases;

import java.util.List;

import com.fiap.lanchoneteapp.application.produto.gateways.ProdutoGateway;
import com.fiap.lanchoneteapp.infrastructure.produto.controllers.dto.ProdutoResponse;

public class BuscarProdutosPorCategoria {

    private final ProdutoGateway produtoGateway;

    public BuscarProdutosPorCategoria(ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway;
    }

    public List<ProdutoResponse> buscarPorCategoria(Integer idCategoria) {
        return produtoGateway.buscarPorCategoria(idCategoria).stream().map(prduto -> new ProdutoResponse(prduto))
                .toList();
    };
}
