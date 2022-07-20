package com.bibliotecacras.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bibliotecacras.model.Editora;
import com.bibliotecacras.services.EditoraService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/Editoras")
@AllArgsConstructor
public class EditoraResource {

    private EditoraService service;

    @GetMapping
    public ResponseEntity<List<Editora>> findAll(){
        List<Editora> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    
   
    @GetMapping(value = "/{id}")
	public ResponseEntity<Editora> findById(@PathVariable Long id) {
		Editora obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
