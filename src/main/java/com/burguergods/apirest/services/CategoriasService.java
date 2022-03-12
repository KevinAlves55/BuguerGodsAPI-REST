package com.burguergods.apirest.services;


import java.util.List;

import javax.transaction.Transactional;

import com.burguergods.apirest.models.Categorias;
import com.burguergods.apirest.repositories.CategoriasRepository;

import org.springframework.stereotype.Service;

@Service
public class CategoriasService {
    
    final CategoriasRepository categoriasRepository;

    public CategoriasService(CategoriasRepository categoriasRepository) {
        this.categoriasRepository = categoriasRepository;
    }

    @Transactional
    public Categorias salvarCategorias(Categorias categorias) {

        return categoriasRepository.save(categorias);

    }

    public List<Categorias> listarTodasCategorias() {

        return categoriasRepository.findAll();

    }

}
