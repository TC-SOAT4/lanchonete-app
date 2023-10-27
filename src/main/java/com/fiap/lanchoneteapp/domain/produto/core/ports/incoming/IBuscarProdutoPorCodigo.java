package com.fiap.lanchoneteapp.domain.produto.core.ports.incoming;

import com.fiap.lanchoneteapp.domain.produto.core.dto.ProdutoResponse;

public interface IBuscarProdutoPorCodigo {

    public ProdutoResponse buscarPorCodigo(Integer codigoProduto);
    
}
