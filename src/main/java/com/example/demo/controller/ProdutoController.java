package com.example.demo.controller;

import com.example.demo.model.Produto;
import com.example.demo.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    // 1. Listar todos os produtos com paginação
    @GetMapping
    public ResponseEntity<Page<Produto>> listarProdutos(Pageable pageable) {
        Page<Produto> produtos = produtoService.listarProdutos(pageable);
        return ResponseEntity.ok(produtos);
    }

    // 2. Buscar produto por nome ou descrição com paginação
    @GetMapping("/buscar")
    public ResponseEntity<Page<Produto>> buscarPorNomeOuDescricao(
            @RequestParam String nome,
            @RequestParam(required = false) String descricao,
            Pageable pageable) {
        Page<Produto> produtos = produtoService.buscarPorNomeOuDescricao(nome, descricao, pageable);
        return ResponseEntity.ok(produtos);
    }

    // 3. Buscar produto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarProdutoPorId(@PathVariable Long id) {
        Optional<Produto> produto = produtoService.buscarPorId(id);
        return produto.map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // 4. Criar novo produto
    @PostMapping
    public ResponseEntity<Produto> criarProduto(@Valid @RequestBody Produto produto) {
        Produto novoProduto = produtoService.salvarProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
    }

    // 5. Atualizar produto existente
    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable Long id,
                                                    @Valid @RequestBody Produto produtoAtualizado) {
        try {
            Produto produto = produtoService.atualizarProduto(id, produtoAtualizado);
            return ResponseEntity.ok(produto);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // 6. Excluir produto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirProduto(@PathVariable Long id) {
        try {
            produtoService.excluirProduto(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
