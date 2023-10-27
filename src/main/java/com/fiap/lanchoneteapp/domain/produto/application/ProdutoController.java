package com.fiap.lanchoneteapp.domain.produto.application;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.lanchoneteapp.domain.produto.core.dto.CadastroProdutoRequest;
import com.fiap.lanchoneteapp.domain.produto.core.dto.EditarProdutoRequest;
import com.fiap.lanchoneteapp.domain.produto.core.dto.ProdutoResponse;
import com.fiap.lanchoneteapp.domain.produto.core.ports.incoming.IBuscarProdutosPorCategoria;
import com.fiap.lanchoneteapp.domain.produto.core.ports.incoming.ICriarProduto;
import com.fiap.lanchoneteapp.domain.produto.core.ports.incoming.IEditarProduto;
import com.fiap.lanchoneteapp.domain.produto.core.ports.incoming.IListarTodoProdutos;
import com.fiap.lanchoneteapp.domain.produto.core.ports.incoming.IRemoverProduto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Tag(name = "Produtos")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ICriarProduto iCriarProduto;
    private final IEditarProduto iEditarProduto;
    private final IRemoverProduto iRemoverProduto;
    private final IListarTodoProdutos iListarTodoProdutos;
    private final IBuscarProdutosPorCategoria iBuscarProdutosPorCategoria;

    @GetMapping
    @Operation(summary = "Listar todos", description = "listar todos os produtos")
    public ResponseEntity<List<ProdutoResponse>> listarTodos() {
        return ResponseEntity.ok().body(iListarTodoProdutos.listarTodos());
    }

    @PostMapping
    @Operation(summary = "Cadastrar", description = "Cadastrar um novo produto")
    public ResponseEntity<ProdutoResponse> cadastrarNovoProduto(
            @RequestBody @Valid CadastroProdutoRequest cadastroProdutoRequest) {
        return ResponseEntity.ok().body(iCriarProduto.cadastrar(cadastroProdutoRequest));
    }

    @PutMapping
    @Operation(summary = "Editar", description = "Editar os dados de um produto cadastrado")
    public ResponseEntity<ProdutoResponse> editarProduto(
            @RequestBody @Valid EditarProdutoRequest editarProdutoRequest) {
        return ResponseEntity.ok().body(iEditarProduto.editar(editarProdutoRequest));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover", description = "Remover um produto")
    public ResponseEntity<ProdutoResponse> removerProduto(@PathVariable(name = "id") Integer idProduto) {
        iRemoverProduto.remover(idProduto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/buscar-por-categoria")
    @Operation(summary = "Buscar por Categoria", description = "Buscar produtos por categoria")
    public ResponseEntity<List<ProdutoResponse>> buscarPorCategoria(
            @RequestParam(name = "codigoCategoria", required = true) Integer codigoCategoria) {
        return ResponseEntity.ok().body(iBuscarProdutosPorCategoria.buscarPorCategoria(codigoCategoria));
    }

}
