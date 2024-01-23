package com.fiap.lanchoneteapp.infrastructure.produto.gateways;

import java.util.List;

import com.fiap.lanchoneteapp.application.produto.gateways.ProdutoGateway;
import com.fiap.lanchoneteapp.domain.produto.entity.Produto;
import com.fiap.lanchoneteapp.infrastructure.produto.persistence.entity.CategoriaEntity;
import com.fiap.lanchoneteapp.infrastructure.produto.persistence.entity.ProdutoEntity;
import com.fiap.lanchoneteapp.infrastructure.produto.persistence.repository.ProdutoRepository;

public class ProdutoRepositoryGateway implements ProdutoGateway {

    private final ProdutoRepository produtoRepository;

    public ProdutoRepositoryGateway(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto cadastrar(Produto produto) {

        ProdutoEntity novoProduto = ProdutoEntity.builder()
                .nome(produto.getNome())
                .descricao(produto.getDescricao())
                .valor(produto.getValor())
                .categoria(new CategoriaEntity(produto.getCategoria()))
                .ativo(Boolean.TRUE)
                .build();

        novoProduto = produtoRepository.save(novoProduto);

        return new Produto(novoProduto);
    }

    @Override
    public Produto editar(Produto produto) {
        ProdutoEntity novoProduto = ProdutoEntity.builder()
                .idProduto(produto.getIdProduto())
                .nome(produto.getNome())
                .descricao(produto.getDescricao())
                .valor(produto.getValor())
                .categoria(new CategoriaEntity(produto.getCategoria()))
                .ativo(produto.getAtivo())
                .build();

        novoProduto = produtoRepository.save(novoProduto);

        return new Produto(novoProduto);
    }

    @Override
    public void remover(Integer id) {
        produtoRepository.findById(id).ifPresent(produtoRepository::delete);
    }

    @Override
    public List<Produto> listarTodos() {
        return produtoRepository.findAll().stream().map(p -> new Produto(p)).toList();
    }

    @Override
    public List<Produto> buscarPorCategoria(Integer idCategoria) {
        return produtoRepository.findAllByCategoriaIdCategoria(idCategoria).stream().map(p -> new Produto(p)).toList();
    }

    @Override
    public Produto buscarPorCodigo(Integer codigoProduto) {
        ProdutoEntity produto = produtoRepository.findById(codigoProduto).get();
        return new Produto(produto);
    }

}
