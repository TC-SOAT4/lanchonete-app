package com.fiap.lanchoneteapp.application.produto.usecases;

import com.fiap.lanchoneteapp.application.produto.gateways.ProdutoGateway;
import com.fiap.lanchoneteapp.domain.produto.entity.Produto;
import com.fiap.lanchoneteapp.infrastructure.produto.controllers.dto.ProdutoResponse;

public class BuscarProdutoPorCodigo {

    private final ProdutoGateway produtoGateway;

    public BuscarProdutoPorCodigo(ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway;
    }

    public ProdutoResponse buscarPorCodigo(Integer codigoProduto) {
        Produto produto = produtoGateway.buscarPorCodigo(codigoProduto);
        return new ProdutoResponse(produto);
    }

}
