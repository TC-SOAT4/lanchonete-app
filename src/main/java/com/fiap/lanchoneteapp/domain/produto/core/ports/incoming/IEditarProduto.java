package com.fiap.lanchoneteapp.domain.produto.core.ports.incoming;

import com.fiap.lanchoneteapp.domain.produto.core.dto.EditarProdutoRequest;
import com.fiap.lanchoneteapp.domain.produto.core.dto.ProdutoResponse;

public interface IEditarProduto {

    public ProdutoResponse editar(EditarProdutoRequest editarProdutoRequest);

}
