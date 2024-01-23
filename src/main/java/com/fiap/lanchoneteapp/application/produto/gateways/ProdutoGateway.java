package com.fiap.lanchoneteapp.application.produto.gateways;

import java.util.List;

import com.fiap.lanchoneteapp.domain.produto.entity.Produto;

public interface ProdutoGateway {

    public Produto buscarPorCodigo(Integer codigoProduto);

    public List<Produto> buscarPorCategoria(Integer idCategoria);

    public Produto cadastrar(Produto produto);

    public Produto editar(Produto produto);

    public List<Produto> listarTodos();

    public void remover(Integer id);

}
