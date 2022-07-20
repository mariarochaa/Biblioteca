package com.bibliotecacras.resources;


import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bibliotecacras.model.Livro;
import com.bibliotecacras.services.LivroService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/livros")
@AllArgsConstructor
public class LivroResource {

    private LivroService service;

    @GetMapping
    @ResponseBody
    public ResponseEntity <List<Livro>> findAll(){
        List<Livro> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    
   
    @GetMapping(value = "/{id}")
	public ResponseEntity<Livro> findById(@PathVariable Long id) {
		Livro obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

    @PostMapping
    public ResponseEntity<Livro> insert (@RequestBody Livro obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

    @PutMapping(value = "/{id}")
	public ResponseEntity<Livro> update(@PathVariable Long id, @RequestBody Livro obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}


}
