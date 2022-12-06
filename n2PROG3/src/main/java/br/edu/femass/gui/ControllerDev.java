package br.edu.femass.gui;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import br.edu.femass.dao.DaoEmprestimo;
import br.edu.femass.dao.DaoExemplar;

import br.edu.femass.model.Emprestimo;
import br.edu.femass.model.Exemplar;
import br.edu.femass.model.Leitor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControllerDev implements Initializable {

    @FXML
    private TableView<Emprestimo> tabela;

    @FXML
    private TableView<Emprestimo> tabela2;
    @FXML
    private TableColumn<Emprestimo, LocalDate> colPrevistaDevolucao;

    @FXML
    private TableColumn<Exemplar, String> colExemplar;

    @FXML
    private TableColumn<Emprestimo, LocalDate> colDev;

    @FXML
    private TableColumn<Emprestimo, Long> ID;

    @FXML
    private TableColumn<Leitor, String> colLeitor;

    DaoEmprestimo daoEmprestimo = new DaoEmprestimo();
    DaoExemplar daoExemplar = new DaoExemplar();
    private Emprestimo emprestimo;

    @FXML
    private void Salvar_dev(ActionEvent event) {
        emprestimo = tabela.getSelectionModel().getSelectedItem();
        emprestimo.setDataDevolucao(LocalDate.now());
        // apagar retiraria o emprestimo, deve ser alteração
        daoEmprestimo.alterar(emprestimo);
        preencherTabela();
        preencherTabelaDev();

    }

    // apaga autores e leitores
    @FXML
    private void Retirar(ActionEvent event) {
        emprestimo = tabela.getSelectionModel().getSelectedItem();
        daoEmprestimo.apagar(emprestimo);
        preencherTabela();
        preencherTabelaDev();

    }

    private void preencherTabela() {
        List<Emprestimo> emprestimos = daoEmprestimo.buscarTodos();
        ObservableList<Emprestimo> dataEmprestimo = FXCollections.observableArrayList(emprestimos);
        tabela.setItems(dataEmprestimo);

    }

    private void preencherTabelaDev() {
        List<Emprestimo> emprestimos = daoEmprestimo.buscarTodos();
        ObservableList<Emprestimo> dataEmprestimo = FXCollections.observableArrayList(emprestimos);
        tabela2.setItems(dataEmprestimo);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ID.setCellValueFactory(new PropertyValueFactory<Emprestimo, Long>("id"));
        colExemplar.setCellValueFactory(new PropertyValueFactory<Exemplar, String>("exemplar"));
        colLeitor.setCellValueFactory(new PropertyValueFactory<Leitor, String>("leitor"));
        colPrevistaDevolucao
                .setCellValueFactory(new PropertyValueFactory<Emprestimo, LocalDate>("dataPrevistaDevolucao"));
        // tabela2
        colDev.setCellValueFactory(new PropertyValueFactory<Emprestimo, LocalDate>("dataDevolucao"));
        preencherTabela();
    }
}