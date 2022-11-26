package br.edu.femass.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String titulo;

    // private List<Autor> autor;

    public Livro(String titulo) {
        this.titulo = titulo;
        // this.autores = autores;

    }

    public Long getId() {
        return id;
    }

    public Livro() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    // public void adicionarAutores(String nome, String sobrenome, String
    // nacionalidade) {
    // if (autor == null)
    // autor = new ArrayList();
    // autor.add(new Autor(nome, sobrenome, nacionalidade));
    // }

    @Override
    public String toString() {
        return this.titulo;
    }

}
