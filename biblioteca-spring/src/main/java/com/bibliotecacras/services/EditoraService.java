package com.bibliotecacras.services;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bibliotecacras.model.Editora;
import com.bibliotecacras.repository.EditoraRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EditoraService {
    
    private EditoraRepository repository;

    public List<Editora> findAll(){
        return repository.findAll();
    }

    public Editora findById(Long id) {
		Optional<Editora> obj = repository.findById(id);
		return obj.get();
	}
}
