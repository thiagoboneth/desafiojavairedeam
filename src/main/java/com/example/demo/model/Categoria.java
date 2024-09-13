package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
public class Categoria {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100)
    private String nome;

    @OneToMany(mappedBy = "categoria")
    private List<Produto> produtos;

    public @NotNull @Size(max = 100) String getNome() {
        return nome;
    }

    public void setNome(@NotNull @Size(max = 100) String nome) {
        this.nome = nome;
    }
}
