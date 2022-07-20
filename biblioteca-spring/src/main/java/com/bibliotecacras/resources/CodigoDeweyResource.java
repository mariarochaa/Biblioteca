package com.bibliotecacras.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bibliotecacras.model.CodigoDewey;
import com.bibliotecacras.services.CodigoDeweyService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/CodigoDeweys")
@AllArgsConstructor
public class CodigoDeweyResource {

    private CodigoDeweyService service;

    @GetMapping
    public ResponseEntity<List<CodigoDewey>> findAll(){
        List<CodigoDewey> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    
   
    @GetMapping(value = "/{codigo}")
	public ResponseEntity<CodigoDewey> findById(@PathVariable String codigo) {
		CodigoDewey obj = service.findById(codigo);
		return ResponseEntity.ok().body(obj);
	}
}
