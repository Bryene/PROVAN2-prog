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
    private Long id;
    private LocalDate dataAquisicao;

    private String nomexemplar;
    @ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    private Livro livro;

    public Exemplar() {
    }

    public Exemplar(Livro livro) throws Exception {
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