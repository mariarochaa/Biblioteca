package com.bibliotecacras.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CodigoDewey {
    
    @Id
    private String codigo;

    @Column (length = 100)
    private String classificacao;

    @OneToMany(cascade=CascadeType.ALL, mappedBy = "cd") //Relacionamento Livro x CD, um Codigo Dewey pode ter muitos livros.
    @JsonIgnore //Evita looping com do relacionamento *Não usa Setters em listas
    private List<Livro> codigosD = new ArrayList<>();

    public CodigoDewey(){

    }

    public CodigoDewey(String codigo, String classificacao) {
        this.codigo = codigo;
        this.classificacao = classificacao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public List<Livro> getCodigosD() {
        return codigosD;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
        CodigoDewey other = (CodigoDewey) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }

    
}
