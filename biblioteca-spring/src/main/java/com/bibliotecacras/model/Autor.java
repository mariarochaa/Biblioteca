package com.bibliotecacras.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Autor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (length = 100)
    private String nomeAutor;

    @Column (length = 100)
    private String nacionalidade;

    //Relacionamento com livro. Muitos para muitos
    //estanciada para garantir que o conjunto nao seja nulo
    @ManyToMany (cascade=CascadeType.PERSIST) //cascade para que o autor seja salva no momento que o livro for salvo.
    @JoinTable(name = "tb_autor_livro", 
    joinColumns = @JoinColumn(name = "autor_id"), 
    inverseJoinColumns = @JoinColumn (name ="livro_id"))
    @JsonIgnore 
    private Set<Livro> livrosA = new HashSet<>();

    public  Autor() {

    }

    public Autor(String nomeAutor, String nacionalidade) {
        this.nomeAutor = nomeAutor;
        this.nacionalidade = nacionalidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public Set<Livro> getLivrosA() {
        return livrosA;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Autor other = (Autor) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    
}
