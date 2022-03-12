package com.burguergods.apirest.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_categorias")
public class Categorias implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCategorias;

    @Column(nullable = false, unique = true, length = 150)
    private String nome;

    /* Getters And Setters */

    public Long getIdCategorias() {
        return idCategorias;
    }

    public void setIdCategorias(Long idCategorias) {
        this.idCategorias = idCategorias;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
