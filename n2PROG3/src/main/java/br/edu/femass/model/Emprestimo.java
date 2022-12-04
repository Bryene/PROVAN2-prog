
/*
 * package br.edu.femass.model;
 * 
 * import java.time.LocalDate;
 * import java.time.format.DateTimeFormatter;
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 * import javax.persistence.CascadeType;
 * import javax.persistence.Entity;
 * import javax.persistence.FetchType;
 * import javax.persistence.GeneratedValue;
 * import javax.persistence.GenerationType;
 * import javax.persistence.Id;
 * import javax.persistence.ManyToOne;
 * 
 * @Entity
 * public class Emprestimo {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.IDENTITY)
 * protected Long id;
 * protected LocalDate dataEmprestimo;
 * protected LocalDate dataDevolucao;
 * protected LocalDate dataPrevistaDevolucao = null;
 * 
 * @ManyToOne(cascade = { CascadeType.ALL })
 * // onde uma entidade é referenciada com outra entidade que contém valores
 * unicos
 * protected Exemplar exemplar;
 * 
 * @ManyToOne(cascade = { CascadeType.ALL })
 * protected Leitor leitor;
 * 
 * protected Livro livro;
 * 
 * public Emprestimo() {
 * this.dataEmprestimo = LocalDate.now();
 * this.dataPrevistaDevolucao = LocalDate.now().plusDays(leitor.getPrazo());
 * }
 * 
 * public Emprestimo(Exemplar exemplar, Leitor leitor) {
 * this.dataEmprestimo = LocalDate.now();
 * this.dataPrevistaDevolucao = LocalDate.now().plusDays(leitor.getPrazo());
 * this.exemplar = exemplar;
 * this.leitor = leitor;
 * 
 * }
 * 
 * public Long getId() {
 * return id;
 * }
 * 
 * public LocalDate getDataEmprestimo() {
 * return dataEmprestimo;
 * }
 * 
 * public void setDataEmprestimo(LocalDate dataEmprestimo) {
 * this.dataEmprestimo = dataEmprestimo;
 * }
 * 
 * public LocalDate getDataPrevistaDevolucao() {
 * return dataPrevistaDevolucao;
 * }
 * 
 * public void setDataPrevistaDevolucao(LocalDate dataPrevistaDevolucao) {
 * this.dataPrevistaDevolucao = dataPrevistaDevolucao;
 * }
 * 
 * public LocalDate getDataDevolucao() {
 * return dataDevolucao;
 * }
 * 
 * public void setDataDevolucao(LocalDate dataDevolucao) {
 * this.dataDevolucao = dataDevolucao;
 * }
 * 
 * public void setExemplar(Exemplar exemplar) {
 * this.exemplar = exemplar;
 * }
 * 
 * public void setLeitor(Leitor leitor) {
 * this.leitor = leitor;
 * }
 * 
 * public String toString() {
 * return (leitor.getNome() + " || " + "Exemplar emprestado: " +
 * exemplar.getLivro());
 * // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
 * // return this.livro.getTitulo() + " - Data de Devolução prevista: "
 * /// + this.dataPrevistaDevolucao.format(formatter);
 * 
 * }
 * 
 * }
 */