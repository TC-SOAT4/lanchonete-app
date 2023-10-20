package com.fiap.lanchoneteapp.domain.produto.core.ports.incoming;

import com.fiap.lanchoneteapp.domain.produto.core.dto.CadastroProdutoRequest;
import com.fiap.lanchoneteapp.domain.produto.core.dto.ProdutoResponse;

public interface ICriarProduto {

    public ProdutoResponse cadastrar(CadastroProdutoRequest cadastroProdutoRequest);
    
}
