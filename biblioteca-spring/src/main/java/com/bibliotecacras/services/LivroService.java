package com.bibliotecacras.services;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;


import com.bibliotecacras.model.Livro;
import com.bibliotecacras.repository.LivroRepository;
import com.bibliotecacras.services.exceptions.DatabaseException;
import com.bibliotecacras.services.exceptions.ResourceNotFoundException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class LivroService {
    
    private LivroRepository repository;

    public List<Livro> findAll(){
        return repository.findAll();
    }

    public Livro findById(Long id) {
		Optional<Livro> obj = repository.findById(id);
		return obj.get();
	}

    public Livro insert(Livro obj){
        return repository.save(obj);
    }
    public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
    }

    public Livro update(Long id, Livro obj) {
		try {
			Livro entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}	
	}

    private void updateData(Livro entity, Livro obj) {
		entity.setIsbn(obj.getIsbn());
		entity.setNome(obj.getNome());
        entity.setAno(obj.getAno());
		entity.setCaminhoImagens(obj.getCaminhoImagens());
		entity.setDescricao(obj.getDescricao());
	}

}
