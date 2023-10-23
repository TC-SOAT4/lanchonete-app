package com.fiap.lanchoneteapp.domain.produto.infrastructure.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.fiap.lanchoneteapp.domain.produto.core.model.Produto;
import com.fiap.lanchoneteapp.domain.produto.core.ports.outgoing.IProdutoPortRepository;
import com.fiap.lanchoneteapp.domain.produto.infrastructure.repository.ProdutoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class ProdutoRepositoryAdapter implements IProdutoPortRepository {

    private final ProdutoRepository produtoRepository;

    @Override
    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public Produto editar(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public void remover(Produto produto) {
        produtoRepository.delete(produto);
    }

    @Override
    public Optional<Produto> buscarPorId(Integer idProduto) {
        return produtoRepository.findById(idProduto);
    }

     @Override
    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    @Override
    public List<Produto> buscarPorCategoria(Integer idCategoria) {
        return produtoRepository.findAllByCategoriaIdCategoria(idCategoria);
    }

}
