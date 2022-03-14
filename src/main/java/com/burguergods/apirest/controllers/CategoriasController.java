package com.burguergods.apirest.controllers;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import com.burguergods.apirest.dtos.CategoriasDto;
import com.burguergods.apirest.models.Categorias;
import com.burguergods.apirest.services.CategoriasService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarCategoria(@PathVariable(value = "id") Long id) {

        Optional<Categorias> categoriasOptional = categoriasService.listarId(id);
        
        if (!categoriasOptional.isPresent()) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Solicitação não encontrada");

        }

        categoriasService.deletarCategoria(categoriasOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Registro deletado com sucesso");

    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarCategorias(@PathVariable(value = "id") Long id, @RequestBody @Valid CategoriasDto categoriasDto) {

        Optional<Categorias> categoriasOptional = categoriasService.listarId(id);

        if (!categoriasOptional.isPresent()) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Solicitação não encontrada");

        }

        var categorias = categoriasOptional.get();
        categorias.setNome(categoriasDto.getNome());

        return ResponseEntity.status(HttpStatus.CREATED).body(categoriasService.salvarCategorias(categorias));

    }
    
}
