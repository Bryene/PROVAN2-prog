package br.edu.femass.model;

import javax.persistence.Entity;

@Entity
public class Professor extends Leitor {
    protected String nome;
    protected String disciplina;
    protected Integer prazoMaximoDev;

    public Professor() {
        prazoMaximoDev = 30;

    }

    public Professor(String nome, String endereco, String telefone, String disciplina) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.disciplina = disciplina;
        prazoMaximoDev = 30;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Integer getPrazo() {
        return prazoMaximoDev;
    }

    public void setPrazo(Integer prazoMaximoDev) {
        this.prazoMaximoDev = 30;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return this.nome + " || " + this.prazoMaximoDev + " dias";
    }
}
