package com.burguergods.apirest.repositories;

import com.burguergods.apirest.models.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriasRepository extends JpaRepository<Categorias, Long> {   
}
