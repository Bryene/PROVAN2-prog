package br.edu.femass.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.jgrapht.alg.cycle.ChordalityInspector.IterationOrder;

@Entity
// separa em tabelas as heranças
@Inheritance(strategy = InheritanceType.JOINED)
public class Leitor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String nome;
    protected String endereco;
    protected String telefone;
    protected Integer prazoMaximoDev;

    public Leitor() {

    }

    public Leitor(String nome, String endereco, String telefone, Integer prazoMaximoDev) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.prazoMaximoDev = prazoMaximoDev;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public Long getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getPrazo() {
        return prazoMaximoDev;
    }

    public void setPrazo(Integer prazoMaximoDev) {
        this.prazoMaximoDev = prazoMaximoDev;
    }

}
