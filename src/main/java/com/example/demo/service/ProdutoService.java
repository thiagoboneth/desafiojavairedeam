package com.example.demo.service;

import com.example.demo.model.Categoria;
import com.example.demo.model.Produto;
import com.example.demo.repository.CategoriaRepository;
import com.example.demo.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    // Listar produtos com paginação
    public Page<Produto> listarProdutos(Pageable pageable) {
        return produtoRepository.findAll(pageable);
    }

    // Buscar produtos por nome ou descrição com paginação
    public Page<Produto> buscarPorNomeOuDescricao(String nome, String descricao, Pageable pageable) {
        return produtoRepository.findByNomeContainingOrDescricaoContaining(nome, descricao, pageable);
    }

    // Buscar produto por ID
    public Optional<Produto> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }

    // Salvar novo produto
    @Transactional
    public Produto salvarProduto(Produto produto) {
        // Regras de negócio: exemplo de validação de categoria existente
        Optional<Categoria> categoria = categoriaRepository.findById(produto.getCategoria().getId());
        if (!categoria.isPresent()) {
            throw new RuntimeException("Categoria não encontrada");
        }
        // Lógica para gerar nome único de imagem pode ser implementada aqui
        return produtoRepository.save(produto);
    }

    // Atualizar produto existente
    @Transactional
    public Produto atualizarProduto(Long id, Produto produtoAtualizado) {
        // Busca produto existente
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        // Atualiza os dados
        produto.setNome(produtoAtualizado.getNome());
        produto.setDescricao(produtoAtualizado.getDescricao());
        produto.setPreco(produtoAtualizado.getPreco());
        produto.setDataValidade(produtoAtualizado.getDataValidade());
        produto.setImagem(produtoAtualizado.getImagem());

        // Atualiza a categoria
        Categoria categoria = categoriaRepository.findById(produtoAtualizado.getCategoria().getId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        produto.setCategoria(categoria);

        return produtoRepository.save(produto);
    }

    // Excluir produto
    @Transactional
    public void excluirProduto(Long id) {
        produtoRepository.deleteById(id);
    }
}
