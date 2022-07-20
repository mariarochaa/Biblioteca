package com.bibliotecacras.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;




@Entity
public class Livro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String isbn;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(length = 100)
    private String autor;

    @Column (length = 200)
    private String subtitulo;

    @Column(length = 100)
    private String editora;

    @Column(length = 200)
    private String codigodewey;

    @Column 
    private String descricao;

   
    @Column(length = 4)
    private Integer ano;

    private String caminhoImagens;
   
   
    //Relacionamento de livros com as categorias. Livro só pode ter uma categoria
    @ManyToOne
    @JoinColumn (name = "tema_id") //Chave estrangeira
    private Categoria tema;

    //Relacionamento de livros com os CD. Livro só pode ter um Codigo Dewey
    @ManyToOne
    @JoinColumn (name = "cd_id") //Chave estrangeira
    private CodigoDewey cd;

    //Relacionamento com autor. Um livro pode ter mais de um autor
    //Set representa um conjunto. Usado para garantir que um mesmo livro não tenha o mesmo autor mais de uma vez
    @ManyToMany(mappedBy = "livrosA")
    private Set<Autor> escritores = new HashSet<>(); 

    //Relacionamento de livros com Editoras. Livro só pode ter uma editora
    @ManyToOne
    @JoinColumn (name = "editora_id") //Chave estrangeira
    private Editora editoraLivro;


    public Livro( String isbn, String nome, String descricao, Integer ano, Categoria tema, String caminhoImagens, String codigodewey) {
       
      
        this.isbn = isbn;
        this.nome = nome;
        this.descricao = descricao;
        this.ano = ano;
        this.tema = tema;
        this.codigodewey = codigodewey;
        this.caminhoImagens = caminhoImagens;
    }
    public Livro() {
    }

    public CodigoDewey getCd() {
        return cd;
    }

    public void setCd(CodigoDewey cd) {
        this.cd = cd;
    }

    
    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public void setEscritores(Set<Autor> escritores) {
        this.escritores = escritores;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Categoria getTema() {
        return tema;
    }

    public void setTema(Categoria tema) {
        this.tema = tema;
    }

    public Editora getEditoraLivro() {
        return editoraLivro;
    }

    public void setEditoraLivro(Editora editoraLivro) {
        this.editoraLivro = editoraLivro;
    }
    public Set<Autor> getEscritores() {
        return escritores;
    }

    public String getCaminhoImagens() {
        return caminhoImagens;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }



    public void setCaminhoImagens(String caminhoImagens) {
        this.caminhoImagens = caminhoImagens;
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
        Livro other = (Livro) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    public String getCodigodewey() {
        return codigodewey;
    }

    public void setCodigodewey(String codigodewey) {
        this.codigodewey = codigodewey;
    }
    
}
