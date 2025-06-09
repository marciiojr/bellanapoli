package com.italianrestaurant.menuservice.Dtos.Response;

import com.italianrestaurant.menuservice.models.Categoria;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class DishReponseDTO {
    private long id;
    private String nome;
    private String descricao;
    private double preco;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    private boolean disponivel;

    public DishReponseDTO() {

    }

    public DishReponseDTO(long id, String nome, String descricao,  double preco, Categoria categoria, boolean disponivel) {
        this.disponivel = disponivel;
        this.categoria = categoria;
        this.preco = preco;
        this.descricao = descricao;
        this.nome = nome;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public double getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getNome() {
        return nome;
    }
}
