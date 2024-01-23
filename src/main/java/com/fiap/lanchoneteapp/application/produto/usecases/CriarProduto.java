package com.fiap.lanchoneteapp.application.produto.usecases;

import com.fiap.lanchoneteapp.application.produto.gateways.ProdutoGateway;
import com.fiap.lanchoneteapp.domain.produto.entity.Categoria;
import com.fiap.lanchoneteapp.domain.produto.entity.Produto;
import com.fiap.lanchoneteapp.infrastructure.produto.controllers.dto.CadastroProdutoRequest;
import com.fiap.lanchoneteapp.infrastructure.produto.controllers.dto.ProdutoResponse;

public class CriarProduto {

    private final ProdutoGateway produtoGateway;

    public CriarProduto(ProdutoGateway produtoGateway) {
        this.produtoGateway = produtoGateway;
    }

    public ProdutoResponse cadastrar(CadastroProdutoRequest cadastroProdutoRequest) {
        Produto novoProduto = Produto.builder()
                .nome(cadastroProdutoRequest.getNome())
                .descricao(cadastroProdutoRequest.getDescricao())
                .valor(cadastroProdutoRequest.getValor())
                .categoria(new Categoria(cadastroProdutoRequest.getCodigoCategoria()))
                .ativo(Boolean.TRUE)
                .build();

        novoProduto = produtoGateway.cadastrar(novoProduto);
        return new ProdutoResponse(novoProduto);
    };

}
