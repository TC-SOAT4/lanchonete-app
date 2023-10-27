package com.fiap.lanchoneteapp.domain.produto.core.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fiap.lanchoneteapp.domain.produto.core.dto.CadastroProdutoRequest;
import com.fiap.lanchoneteapp.domain.produto.core.dto.EditarProdutoRequest;
import com.fiap.lanchoneteapp.domain.produto.core.dto.ProdutoResponse;
import com.fiap.lanchoneteapp.domain.produto.core.model.Categoria;
import com.fiap.lanchoneteapp.domain.produto.core.model.Produto;
import com.fiap.lanchoneteapp.domain.produto.core.ports.incoming.IBuscarProdutoPorCodigo;
import com.fiap.lanchoneteapp.domain.produto.core.ports.incoming.IBuscarProdutosPorCategoria;
import com.fiap.lanchoneteapp.domain.produto.core.ports.incoming.ICriarProduto;
import com.fiap.lanchoneteapp.domain.produto.core.ports.incoming.IEditarProduto;
import com.fiap.lanchoneteapp.domain.produto.core.ports.incoming.IListarTodoProdutos;
import com.fiap.lanchoneteapp.domain.produto.core.ports.incoming.IRemoverProduto;
import com.fiap.lanchoneteapp.domain.produto.core.ports.outgoing.IProdutoPortRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProdutoService implements ICriarProduto, IEditarProduto, IRemoverProduto, IListarTodoProdutos, IBuscarProdutosPorCategoria, IBuscarProdutoPorCodigo {

    private final IProdutoPortRepository iProdutoPortRepository;

    public ProdutoResponse cadastrar(CadastroProdutoRequest cadastroProdutoRequest) {

        Produto novoProduto = Produto.builder()
                .nome(cadastroProdutoRequest.getNome())
                .descricao(cadastroProdutoRequest.getDescricao())
                .valor(cadastroProdutoRequest.getValor())
                .categoria(new Categoria(cadastroProdutoRequest.getCodigoCategoria()))
                .ativo(Boolean.TRUE)
                .build();

        novoProduto = iProdutoPortRepository.salvar(novoProduto);

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

        novoProduto = iProdutoPortRepository.salvar(novoProduto);

        return new ProdutoResponse(novoProduto);
    }

    @Override
    public void remover(Integer id) {
        iProdutoPortRepository.buscarPorId(id).ifPresent(iProdutoPortRepository::remover);
    }

    @Override
    public List<ProdutoResponse> listarTodos() {
        return iProdutoPortRepository.listarTodos().stream().map(prduto -> new ProdutoResponse(prduto)).toList();
    }

    @Override
    public List<ProdutoResponse> buscarPorCategoria(Integer idCategoria) {
        return iProdutoPortRepository.buscarPorCategoria(idCategoria).stream().map(prduto -> new ProdutoResponse(prduto)).toList();
    }

    @Override
    public ProdutoResponse buscarPorCodigo(Integer codigoProduto) {
        Produto produto = iProdutoPortRepository.buscarPorId(codigoProduto).get();
        return new ProdutoResponse(produto);
    }

}
