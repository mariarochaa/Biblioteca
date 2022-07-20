package com.bibliotecacras.services;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bibliotecacras.model.Autor;
import com.bibliotecacras.repository.AutorRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AutorService {
    
    private AutorRepository repository;

    public List<Autor> findAll(){
        return repository.findAll();
    }

    public Autor findById(Long id) {
		Optional<Autor> obj = repository.findById(id);
		return obj.get();
	}
}
