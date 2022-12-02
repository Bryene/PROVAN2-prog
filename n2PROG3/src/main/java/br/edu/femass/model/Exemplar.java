package br.edu.femass.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Exemplar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected LocalDate dataAquisicao;

    protected String nomexemplar;
    @ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    protected Livro livro;

    public Exemplar() {
        this.dataAquisicao = LocalDate.now();
    }

    public Exemplar(Livro livro) {
        this.dataAquisicao = LocalDate.now();
        // livro em exemplar
        this.nomexemplar = livro.toString();
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDataAquisicao() {
        return dataAquisicao;
    }

    public String getNomexemplar() {
        return nomexemplar;
    }

    public void setNomexemplar(String nomexemplar) {
        this.nomexemplar = nomexemplar;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    @Override
    public String toString() {
        return this.getNomexemplar();
    }

}