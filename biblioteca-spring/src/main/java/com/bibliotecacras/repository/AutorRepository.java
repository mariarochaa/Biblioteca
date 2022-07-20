package com.bibliotecacras.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bibliotecacras.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{
    
}
 