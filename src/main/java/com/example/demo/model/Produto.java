package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import javax.net.ssl.SSLSession;
import java.time.LocalDate;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 50)
    private String nome;

    @Size(max = 200)
    private String descricao;

    @Positive
    private Double preco;

    @FutureOrPresent
    private LocalDate dataValidade;

    @Setter
    @Getter
    private String imagem;


    public Categoria getCategoria() {
        return categoria;
    }


    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public @Size(max = 50) String getNome() {
        return nome;
    }

    public void setNome(@Size(max = 50) String nome) {
        this.nome = nome;
    }

    public @Size(max = 200) String getDescricao() {
        return descricao;
    }

    public void setDescricao(@Size(max = 200) String descricao) {
        this.descricao = descricao;
    }

    public @Positive Double getPreco() {
        return preco;
    }

    public void setPreco(@Positive Double preco) {
        this.preco = preco;
    }

    public @FutureOrPresent LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(@FutureOrPresent LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }
}

