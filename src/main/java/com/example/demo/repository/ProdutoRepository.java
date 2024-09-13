package com.example.demo.repository;

import com.example.demo.model.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Page<Produto> findByNomeContainingOrDescricaoContaining(String nome, String descricao, Pageable pageable);
}

