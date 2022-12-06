package br.edu.femass.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String titulo;

    // eager= usado quando não faz sentido puxar um objeto do BD sem puxar um outro
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Autor autor;
    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    private List<Exemplar> exemplares;

    public Livro() {
    }

    public Long getId() {
        return id;
    }

    public Livro(String titulo, Autor autor, String ano) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutores() {
        return autor;
    }

    public void setAutores(Autor autor) {
        this.autor = autor;
    }

    public List<Exemplar> getExemplares() {
        return exemplares;
    }

    @Override
    public String toString() {
        return "Titulo: " + titulo + " || " + autor;
    }

}
