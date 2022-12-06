package br.edu.femass.gui;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.femass.dao.DaoAluno;
import br.edu.femass.dao.DaoEmprestimo;
import br.edu.femass.dao.DaoExemplar;
import br.edu.femass.dao.DaoLeitor;
import br.edu.femass.dao.DaoProfessor;
import br.edu.femass.model.Aluno;
import br.edu.femass.model.Emprestimo;
import br.edu.femass.model.Exemplar;
import br.edu.femass.model.Leitor;
import br.edu.femass.model.Livro;
import br.edu.femass.model.Professor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControllerEmprestimo implements Initializable {

    @FXML
    private ComboBox<Aluno> comboAluno;

    @FXML
    private ComboBox<Professor> comboProfessor;

    @FXML
    private ComboBox<Leitor> comboLeitor;

    @FXML
    private ListView<Exemplar> LstExemplares;

    @FXML
    private TableView<Exemplar> titulo = new TableView<>();

    @FXML
    private TableView<Emprestimo> tabela = new TableView<>();

    @FXML
    private TableColumn<Emprestimo, Long> ID;

    @FXML
    private TableColumn<Exemplar, String> colExemplar;

    @FXML
    private TableColumn<Leitor, String> colLeitor;

    @FXML
    private TableColumn<Emprestimo, LocalDate> colData;

    DaoEmprestimo daoEmprestimo = new DaoEmprestimo();
    DaoExemplar daoExemplar = new DaoExemplar();
    DaoAluno daoAluno = new DaoAluno();
    DaoProfessor daoProfessor = new DaoProfessor();
    DaoLeitor daoLeitor = new DaoLeitor();

    private Exemplar exemplar;
    private Emprestimo emprestimo;
    private Aluno aluno;
    private Professor professor;
    private Leitor leitor;

    private void preencherLista() {
        List<Exemplar> exemplares = daoExemplar.buscarTodos();
        ObservableList<Exemplar> data = FXCollections.observableList(exemplares);
        LstExemplares.setItems(data);

    }

    private void preencherTabela() {
        exemplar = titulo.getSelectionModel().getSelectedItem();
        List<Emprestimo> emprestimos = daoEmprestimo.buscarTodos();
        ObservableList<Emprestimo> dataEmprestimo = FXCollections.observableArrayList(emprestimos);
        tabela.setItems(dataEmprestimo);

    }

    @FXML
    private void Btnaluno(ActionEvent event) {
        aluno = comboAluno.getSelectionModel().getSelectedItem();
        emprestimo = new Emprestimo(exemplar, aluno);
        daoEmprestimo.inserir(emprestimo);
        preencherCombo();
        preencherTabela();
    }

    @FXML
    private void Btnprofessor(ActionEvent event) {
        professor = comboProfessor.getSelectionModel().getSelectedItem();
        emprestimo = new Emprestimo(exemplar, professor);
        daoEmprestimo.inserir(emprestimo);
        preencherCombo();
        preencherTabela();
    }

    private void preencherCombo() {

        List<Leitor> leitores = daoLeitor.buscarTodos();
        ObservableList<Leitor> dataLeitor = FXCollections.observableArrayList(leitores);
        List<Aluno> alunos = daoAluno.buscarTodos();
        ObservableList<Aluno> dataAluno = FXCollections.observableArrayList(alunos);
        comboAluno.setItems(dataAluno);
        List<Professor> professores = daoProfessor.buscarTodos();
        ObservableList<Professor> dataProfessor = FXCollections.observableArrayList(professores);
        comboProfessor.setItems(dataProfessor);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ID.setCellValueFactory(new PropertyValueFactory<Emprestimo, Long>("id"));
        colLeitor.setCellValueFactory(new PropertyValueFactory<Leitor, String>("leitor"));
        colExemplar.setCellValueFactory(new PropertyValueFactory<Exemplar, String>("exemplar"));
        colData.setCellValueFactory(new PropertyValueFactory<Emprestimo, LocalDate>("dataPrevistaDevolucao"));
        emprestimo = new Emprestimo();
        preencherTabela();
        preencherCombo();
        preencherLista();
    }
}