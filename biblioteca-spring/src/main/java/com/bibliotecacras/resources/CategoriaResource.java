package com.bibliotecacras.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bibliotecacras.model.Categoria;
import com.bibliotecacras.services.CategoriaService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/livros/categorias")
@AllArgsConstructor
public class CategoriaResource {

    private CategoriaService service;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Categoria>> findAll(){
        List<Categoria> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    
   
    @GetMapping(value = "/{codigo}")
	public ResponseEntity<Categoria> findById(@PathVariable String codigo) {
		Categoria obj = service.findById(codigo);
		return ResponseEntity.ok().body(obj);
	}

    @PostMapping
	public ResponseEntity<Categoria> insert(@RequestBody Categoria obj) {
		obj = service.insert(obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value = "/{codigo}")
	public ResponseEntity<Void> delete(@PathVariable String codigo) {
		service.delete(codigo);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{codigo}")
	public ResponseEntity<Categoria> update(@PathVariable String codigo, @RequestBody Categoria obj) {
		obj = service.update(codigo, obj);
		return ResponseEntity.ok().body(obj);
	}
}
