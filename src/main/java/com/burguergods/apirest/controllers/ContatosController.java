package com.burguergods.apirest.controllers;

import javax.validation.Valid;

import com.burguergods.apirest.dtos.ContatosDto;
import com.burguergods.apirest.models.Contatos;
import com.burguergods.apirest.services.ContatosService;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/contatos")
public class ContatosController {

    final ContatosService contatosService;

    public ContatosController(ContatosService contatosService) {
        this.contatosService = contatosService;
    }

    @PostMapping
    public ResponseEntity<Object> salvarContato(@RequestBody @Valid ContatosDto contatosDto) {  

        var contatos = new Contatos();
        BeanUtils.copyProperties(contatosDto, contatos);
        return ResponseEntity.status(HttpStatus.CREATED).body(contatosService.salvarContato(contatos));
        
    }
    
}
