package com.bibliotecacras.services;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bibliotecacras.model.CodigoDewey;
import com.bibliotecacras.repository.CodigoDeweyRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CodigoDeweyService {
    
    private CodigoDeweyRepository repository;

    public List<CodigoDewey> findAll(){
        return repository.findAll();
    }

    public CodigoDewey findById(String codigo) {
		Optional<CodigoDewey> obj = repository.findById(codigo);
		return obj.get();
	}
}
