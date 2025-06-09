package com.italianrestaurant.menuservice.Dtos.Request;

import com.italianrestaurant.menuservice.models.Categoria;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class DishRequestDTO {
    private String nome;
    private String descricao;
    private double preco;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    private boolean disponivel;

    public DishRequestDTO() {

    }

    public DishRequestDTO(boolean disponivel, Categoria categoria, double preco, String descricao, String nome) {
        this.disponivel = disponivel;
        this.categoria = categoria;
        this.preco = preco;
        this.descricao = descricao;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
