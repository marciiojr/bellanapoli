package com.italianrestaurant.menuservice.Dtos.Request;

public class DishRequestDTO {
    private String nome;
    private String descricao;
    private double preco;
    private String categoria;
    private boolean disponivel;

    public DishRequestDTO() {

    }

    public DishRequestDTO(boolean disponivel, String categoria, double preco, String descricao, String nome) {
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
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
