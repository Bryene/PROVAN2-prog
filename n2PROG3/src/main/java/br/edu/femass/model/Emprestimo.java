package br.edu.femass.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataEmprestimo;
    private LocalDate dataPrevisaoDevolucao;
    private LocalDate dataDevolucao;

    // registros de uma entidade estão relacionados com muitos registros de outra
    // entidade
    @ManyToOne(cascade = CascadeType.ALL)
    private Exemplar exemplar;

    @ManyToOne(cascade = CascadeType.ALL)
    private Leitor leitor;

    public Emprestimo() {

    }

    public Emprestimo(Exemplar exemplar, Leitor leitor) {
        this.dataEmprestimo = LocalDate.now();
        this.dataPrevisaoDevolucao = LocalDate.now().plusDays(leitor.prazoMaximoDev);
        this.exemplar = exemplar;
        this.leitor = leitor;

    }

    public Long getId() {
        return id;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataPrevisaoDevolucao() {
        return dataPrevisaoDevolucao;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    public Leitor getLeitor() {
        return leitor;
    }

    public void setLeitor(Leitor leitor) {
        this.leitor = leitor;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public void setDataPrevisaoDevolucao(LocalDate dataPrevisaoDevolucao) {
        this.dataPrevisaoDevolucao = dataPrevisaoDevolucao;
    }
}