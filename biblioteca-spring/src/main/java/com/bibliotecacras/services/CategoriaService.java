package com.bibliotecacras.services;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.bibliotecacras.model.Categoria;
import com.bibliotecacras.repository.CategoriaRepository;
import com.bibliotecacras.services.exceptions.DatabaseException;
import com.bibliotecacras.services.exceptions.ResourceNotFoundException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CategoriaService {
    
    private CategoriaRepository repository;

    public List<Categoria> findAll(){
        return repository.findAll();
    }

    public Categoria findById(String codigo) {
		Optional<Categoria> obj = repository.findById(codigo);
		return obj.get();
	}

    public Categoria insert(Categoria obj) {
		return repository.save(obj);
	}
	
	public void delete(String codigo) {
		try {
			repository.deleteById(codigo);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(codigo);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Categoria update(String codigo, Categoria obj) {
		try {
			Categoria entity = repository.getReferenceById(codigo);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(codigo);
		}	
	}

	private void updateData(Categoria entity, Categoria obj) {
		entity.setCodigo(obj.getCodigo());
		entity.setNomeCategoria(obj.getNomeCategoria());
		
	}
}
