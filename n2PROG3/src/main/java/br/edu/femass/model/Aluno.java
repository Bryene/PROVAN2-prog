package br.edu.femass.model;

import javax.persistence.Entity;

@Entity
public class Aluno extends Leitor {
    protected String nome;
    protected String matricula;
    protected Integer prazoMaximoDev;

    public Aluno() {

        prazoMaximoDev = 15;
    }

    public Aluno(String nome, String endereco, String telefone, String matricula) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.matricula = matricula;
        prazoMaximoDev = 15;
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
        this.prazoMaximoDev = 15;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return this.nome + " || " + this.matricula + " || " + this.prazoMaximoDev + " dias";
    }
}
