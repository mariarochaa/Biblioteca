package com.bibliotecacras.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bibliotecacras.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, String>{
    
}
 