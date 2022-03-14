package com.burguergods.apirest.services;

import javax.transaction.Transactional;
import com.burguergods.apirest.models.Contatos;
import com.burguergods.apirest.repositories.ContatosRepository;

import org.springframework.stereotype.Service;

@Service
public class ContatosService {

    final ContatosRepository contatosRepository;

    public ContatosService(ContatosRepository contatosRepository) {
        this.contatosRepository = contatosRepository;
    }

    @Transactional
    public Contatos salvarContato(Contatos contatos) {
        
        return contatosRepository.save(contatos);
    
    }
    
}
