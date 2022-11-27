/*
 * package br.edu.femass.model;
 * 
 * import java.time.LocalDate;
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 * import javax.persistence.CascadeType;
 * import javax.persistence.Entity;
 * import javax.persistence.GeneratedValue;
 * import javax.persistence.GenerationType;
 * import javax.persistence.Id;
 * import javax.persistence.OneToMany;
 * 
 * @Entity
 * public class Exemplar {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.IDENTITY)
 * protected Long id;
 * protected Livro livro;
 * protected LocalDate dataAquisicao;
 * 
 * 
 * public Long getId() {
 * return id;
 * }
 * 
 * public Exemplar() {
 * }
 * 
 * public Exemplar(Livro livro) {
 * this.dataAquisicao = LocalDate.now();
 * }
 * 
 * @OneToMany(cascade = CascadeType.ALL)
 * protected List<Livro> autores = new ArrayList<Livro>();
 * 
 * public Livro getLivro() {
 * return livro;
 * }
 * 
 * public void setLivro(Livro livro) {
 * this.livro = livro;
 * }
 * 
 * @Override
 * public String toString() {
 * return "Livro: " + livro + " || " + "Data: " + dataAquisicao;
 * }
 * }
 */