package com.burguergods.apirest.dtos;

import javax.validation.constraints.NotBlank;

public class CategoriasDto {
    
    @NotBlank
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
