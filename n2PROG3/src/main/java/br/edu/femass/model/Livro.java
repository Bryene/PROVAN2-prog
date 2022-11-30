package br.edu.femass.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String titulo;

    public Livro(String titulo) {
        this.titulo = titulo;

    }

    public Livro() {
    }

    public Long getId() {
        return id;
    }

    @OneToMany(cascade = CascadeType.ALL)
    protected List<Autor> autores = new ArrayList<Autor>();

    // protected List<Exemplar> exemplares = new ArrayList<Exemplar>();

    public Livro(String titulo, List<Autor> autores) {
        if (autores == null)
            autores = new ArrayList<>();
        autores.addAll(autores);
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    // public List<Exemplar> getExemplares() {
    // return exemplares;
    // }

    // public void setExemplares(List<Exemplar> exemplares) {
    // this.exemplares = exemplares;
    // }

    @Override
    public String toString() {
        return "Titulo: " + titulo;
    }

}