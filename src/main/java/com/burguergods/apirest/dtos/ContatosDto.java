package com.burguergods.apirest.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class ContatosDto {

    @NotBlank(message = "{nome.not.blank}")
    private String nome;

    @NotBlank(message = "{email.not.blank}")
    @Email(message = "{email.not.valid}")
    private String email;

    @NotBlank(message = "{celular.not.blank}")
    private String celular;

     /* Getters And Setters */
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }   
    
}
