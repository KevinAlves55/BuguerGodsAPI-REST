package com.burguergods.apirest.controllers;

import java.util.List;

import javax.validation.Valid;

import com.burguergods.apirest.dtos.CategoriasDto;
import com.burguergods.apirest.models.Categorias;
import com.burguergods.apirest.services.CategoriasService;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/categorias")
public class CategoriasController {

    final CategoriasService categoriasService;

    public CategoriasController(CategoriasService categoriasService) {
        this.categoriasService = categoriasService;
    }

    @PostMapping
    public ResponseEntity<Object> salvarCategorias(@RequestBody @Valid CategoriasDto categoriasDto) {  

        var categorias = new Categorias();
        BeanUtils.copyProperties(categoriasDto, categorias);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriasService.salvarCategorias(categorias));
        
    }

    @GetMapping
    public ResponseEntity<List<Categorias>> listarTodasCategorias() {
        
        return ResponseEntity.status(HttpStatus.OK).body(categoriasService.listarTodasCategorias());

    }
    
    
    
}
