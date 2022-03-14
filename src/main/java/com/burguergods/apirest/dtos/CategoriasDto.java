package com.burguergods.apirest.dtos;

import javax.validation.constraints.NotBlank;

public class CategoriasDto {
    
    @NotBlank(message = "{nome.not.blank}")
    private String nome;

    /* Getters And Setters */

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
