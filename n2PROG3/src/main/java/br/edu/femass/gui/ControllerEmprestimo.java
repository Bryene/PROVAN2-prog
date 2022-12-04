/*
 * package br.edu.femass.gui;
 * 
 * import java.net.URL;
 * import java.time.LocalDate;
 * import java.util.ArrayList;
 * import java.util.List;
 * import java.util.ResourceBundle;
 * 
 * import org.hibernate.criterion.EmptyExpression;
 * 
 * import br.edu.femass.dao.DaoAluno;
 * import br.edu.femass.dao.DaoEmprestimo;
 * import br.edu.femass.dao.DaoExemplar;
 * import br.edu.femass.dao.DaoLeitor;
 * import br.edu.femass.dao.DaoLivro;
 * import br.edu.femass.dao.DaoProfessor;
 * import br.edu.femass.model.Aluno;
 * import br.edu.femass.model.Emprestimo;
 * import br.edu.femass.model.Exemplar;
 * import br.edu.femass.model.Leitor;
 * import br.edu.femass.model.Livro;
 * import br.edu.femass.model.Professor;
 * import javafx.collections.FXCollections;
 * import javafx.collections.ObservableList;
 * import javafx.event.ActionEvent;
 * import javafx.fxml.FXML;
 * import javafx.fxml.FXMLLoader;
 * import javafx.fxml.Initializable;
 * import javafx.scene.Parent;
 * import javafx.scene.Scene;
 * import javafx.scene.control.Button;
 * import javafx.scene.control.ComboBox;
 * import javafx.scene.control.ListView;
 * import javafx.scene.control.TextField;
 * import javafx.scene.input.KeyEvent;
 * import javafx.scene.input.MouseEvent;
 * import javafx.stage.Stage;
 * 
 * public class ControllerEmprestimo implements Initializable {
 * 
 * @FXML
 * private Button BtnSalvar;
 * 
 * @FXML
 * private Button BtnIncluir;
 * 
 * @FXML
 * private Button BtnAlterar;
 * 
 * @FXML
 * private Button BtnExcluir;
 * 
 * @FXML
 * private ComboBox<Leitor> cbLeitor;
 * 
 * @FXML
 * private ComboBox<Exemplar> cbExemplar;
 * 
 * @FXML
 * private ListView<Emprestimo> lstEmprestimos;
 * 
 * DaoExemplar daoExemplar = new DaoExemplar();
 * DaoLeitor daoLeitor = new DaoLeitor();
 * // DaoProfessor daoProfessor = new DaoProfessor();
 * // DaoAluno daoAluno = new DaoAluno();
 * 
 * DaoEmprestimo dao = new DaoEmprestimo();
 * private Emprestimo emprestimo;
 * private Boolean incluindo;
 * 
 * @FXML
 * private void Gravar_Click(ActionEvent event) {
 * emprestimo.setExemplar(cbExemplar.getSelectionModel().getSelectedItem());
 * emprestimo.setLeitor(cbLeitor.getSelectionModel().getSelectedItem());
 * 
 * if (incluindo) {
 * dao.inserir(emprestimo);
 * } else {
 * dao.alterar(emprestimo);
 * }
 * 
 * preencherLista();
 * preencherExemplar();
 * preencherComboLeitor();
 * editar(false);
 * BtnIncluir.setStyle(null);
 * BtnAlterar.setStyle(null);
 * BtnExcluir.setStyle(null);
 * 
 * }
 * 
 * @FXML
 * private void incluir_click(ActionEvent event) {
 * editar(true);
 * incluindo = true;
 * emprestimo = new Emprestimo();
 * cbLeitor.setValue(null);
 * cbExemplar.setValue(null);
 * BtnIncluir.setStyle("-fx-background-color: MediumSeaGreen");
 * BtnExcluir.setStyle(null);
 * }
 * 
 * @FXML
 * private void alterar_click(ActionEvent event) {
 * editar(true);
 * incluindo = true;
 * BtnAlterar.setStyle("-fx-background-color: Green");
 * BtnExcluir.setStyle(null);
 * }
 * 
 * @FXML
 * private void excluir_click(ActionEvent event) {
 * dao.apagar(emprestimo);
 * preencherLista();
 * BtnExcluir.setStyle(null);
 * 
 * }
 * 
 * @FXML
 * private void keyPressed_teclaSelecionada(KeyEvent event) {
 * exibirDados();
 * }
 * 
 * @FXML
 * private void valor_Selecionado(MouseEvent event) {
 * exibirDados();
 * }
 * 
 * private void editar(boolean habilitar) {
 * lstEmprestimos.setDisable(habilitar);
 * cbExemplar.setDisable(!habilitar);
 * cbLeitor.setDisable(!habilitar);
 * BtnAlterar.setDisable(habilitar);
 * BtnIncluir.setDisable(habilitar);
 * BtnExcluir.setDisable(habilitar);
 * BtnSalvar.setDisable(habilitar);
 * }
 * 
 * private void exibirDados() {
 * this.emprestimo = lstEmprestimos.getSelectionModel().getSelectedItem();
 * if (emprestimo == null)
 * BtnExcluir.setStyle(null);
 * return;
 * }
 * 
 * private void preencherLista() {
 * List<Emprestimo> emprestimos = DaoEmprestimo.buscarTodos();
 * ObservableList<Emprestimo> data =
 * FXCollections.observableArrayList(emprestimos);
 * lstEmprestimos.setItems(data);
 * }
 * 
 * private void preencherExemplar() {
 * // cbExemplar.getItems().clear();
 * List<Exemplar> exemplares = DaoExemplar.buscarTodos();
 * ObservableList<Exemplar> data2 =
 * FXCollections.observableArrayList(exemplares);
 * cbExemplar.setItems(data2);
 * }
 * 
 * private void preencherComboLeitor() {
 * List<Leitor> leitores = daoLeitor.buscarTodos();
 * ObservableList<Leitor> data3 = FXCollections.observableArrayList(leitores);
 * cbLeitor.setItems(data3);
 * }
 * 
 * /*
 * 
 * @FXML
 * private void btnDevolverAction(ActionEvent event) {
 * try {
 * Emprestimo emprestimoSelecionado =
 * lstEmprestimos.getSelectionModel().getSelectedItem();
 * emprestimoSelecionado.setDataDevolucao(LocalDate.now());
 * DaoEmprestimo.alterar(emprestimoSelecionado);
 * preencherLista();
 * lstEmprestimos.setDisable(false);
 * } catch (Exception e) {
 * e.printStackTrace();
 * }
 * }
 */

/*
 * @Override
 * public void initialize(URL location, ResourceBundle resources) {
 * preencherLista();
 * }
 * 
 * }
 */