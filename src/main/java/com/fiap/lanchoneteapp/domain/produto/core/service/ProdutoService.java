package com.fiap.lanchoneteapp.domain.produto.core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fiap.lanchoneteapp.domain.produto.core.dto.CadastroProdutoRequest;
import com.fiap.lanchoneteapp.domain.produto.core.dto.EditarProdutoRequest;
import com.fiap.lanchoneteapp.domain.produto.core.dto.ProdutoResponse;
import com.fiap.lanchoneteapp.domain.produto.core.model.Categoria;
import com.fiap.lanchoneteapp.domain.produto.core.model.Produto;
import com.fiap.lanchoneteapp.domain.produto.core.ports.incoming.ICriarProduto;
import com.fiap.lanchoneteapp.domain.produto.core.ports.incoming.IEditarProduto;
import com.fiap.lanchoneteapp.domain.produto.core.ports.incoming.IListarTodoProdutos;
import com.fiap.lanchoneteapp.domain.produto.core.ports.incoming.IRemoverProduto;
import com.fiap.lanchoneteapp.domain.produto.infrastructure.persistence.ProdutoRepositoryAdapter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProdutoService implements ICriarProduto, IEditarProduto, IRemoverProduto, IListarTodoProdutos {

    private final ProdutoRepositoryAdapter produtoRepositoryAdapter;

    public ProdutoResponse cadastrar(CadastroProdutoRequest cadastroProdutoRequest) {

        Produto novoProduto = Produto.builder()
                .nome(cadastroProdutoRequest.getNome())
                .descricao(cadastroProdutoRequest.getDescricao())
                .valor(cadastroProdutoRequest.getValor())
                .categoria(new Categoria(cadastroProdutoRequest.getCodigoCategoria()))
                .ativo(Boolean.TRUE)
                .build();

        novoProduto = produtoRepositoryAdapter.salvar(novoProduto);

        return new ProdutoResponse(novoProduto);
    }

    @Override
    public ProdutoResponse editar(EditarProdutoRequest editarProdutoRequest) {
        Produto novoProduto = Produto.builder()
                .idProduto(editarProdutoRequest.getIdProduto())
                .nome(editarProdutoRequest.getNome())
                .descricao(editarProdutoRequest.getDescricao())
                .valor(editarProdutoRequest.getValor())
                .categoria(editarProdutoRequest.getCategoria())
                .ativo(editarProdutoRequest.getAtivo())
                .build();

        novoProduto = produtoRepositoryAdapter.salvar(novoProduto);

        return new ProdutoResponse(novoProduto);
    }

    @Override
    public void remover(Integer id) {
        produtoRepositoryAdapter.buscarPorId(id).ifPresent(produtoRepositoryAdapter::remover);
    }

    @Override
    public List<ProdutoResponse> listarTodos() {
        return produtoRepositoryAdapter.listarTodos().stream().map(prduto -> new ProdutoResponse(prduto)).toList();
    }

}
