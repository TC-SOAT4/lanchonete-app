package com.fiap.lanchoneteapp.domain.produto.core.ports.outgoing;

import java.util.Optional;

import com.fiap.lanchoneteapp.domain.produto.core.model.Produto;

public interface IProdutoPortRepository {

    public Produto salvar(Produto produto);

    public Produto editar(Produto produto);

    public void remover(Produto produto);

    public Optional<Produto> buscarPorId(Integer idProduto);

}
