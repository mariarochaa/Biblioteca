package com.bibliotecacras.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Categoria {
    
    @Id
    private String codigo;

    @Column (length = 100)
    private String nomeCategoria;

    @OneToMany(cascade=CascadeType.ALL , mappedBy = "tema") //Relacionamento Livro x Categoria, uma Categoria pode ter muitos livros.
    @JsonIgnore //Evita looping com do relacionamento *Não usa Setters em listas
    private Set<Livro> categories = new HashSet<>();
    
    public Categoria(){
    }

    public Categoria(String codigo, String nomeCategoria) {
        this.codigo = codigo;
        this.nomeCategoria = nomeCategoria;
       
    }

    public Set<Livro> getCategories() {
        return categories;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

}
