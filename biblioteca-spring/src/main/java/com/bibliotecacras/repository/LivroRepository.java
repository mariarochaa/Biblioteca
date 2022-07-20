package com.bibliotecacras.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bibliotecacras.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{
    
}
