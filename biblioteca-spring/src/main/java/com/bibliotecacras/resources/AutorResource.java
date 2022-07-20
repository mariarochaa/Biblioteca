package com.bibliotecacras.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bibliotecacras.model.Autor;
import com.bibliotecacras.services.AutorService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/livros/autores")
@AllArgsConstructor
public class AutorResource {

    private AutorService service;

    @GetMapping
    public ResponseEntity<List<Autor>> findAll(){
        List<Autor> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    
   
    @GetMapping(value = "/{id}")
	public ResponseEntity<Autor> findById(@PathVariable Long id) {
		Autor obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
