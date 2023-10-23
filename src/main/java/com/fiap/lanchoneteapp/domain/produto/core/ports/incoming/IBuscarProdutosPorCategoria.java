package com.fiap.lanchoneteapp.domain.produto.core.ports.incoming;

import java.util.List;

import com.fiap.lanchoneteapp.domain.produto.core.dto.ProdutoResponse;

public interface IBuscarProdutosPorCategoria {
    public List<ProdutoResponse> buscarPorCategoria(Integer idCategoria);
}
