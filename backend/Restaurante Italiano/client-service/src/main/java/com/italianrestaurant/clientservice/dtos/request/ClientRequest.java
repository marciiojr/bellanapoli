package com.italianrestaurant.clientservice.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientRequest {
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private String endereco;
    private String Senha;


    public ClientRequest(String nome, String cpf, String email, String telefone, String endereco, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        Senha = senha;
    }
}
