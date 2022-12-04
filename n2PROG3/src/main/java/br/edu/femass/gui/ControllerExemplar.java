package br.edu.femass.gui;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.femass.dao.DaoExemplar;
import br.edu.femass.dao.DaoLivro;
import br.edu.femass.model.Exemplar;
import br.edu.femass.model.Livro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import net.bytebuddy.asm.Advice.Local;

public class ControllerExemplar implements Initializable {

    @FXML
    private ComboBox<Livro> comboLivro;

    @FXML
    private TableView<Exemplar> tabela;

    @FXML
    private TableColumn<Livro, String> colExemplar;

    @FXML
    private TableColumn<Exemplar, LocalDate> coldata;

    @FXML
    private TableColumn<Exemplar, Long> ID;

    @FXML
    private Button btnRegistrar;

    @FXML
    private Button btnAlterar;

    @FXML
    private Button btnExcluir;

    @FXML
    private Button btnIncluir;

    DaoExemplar dao = new DaoExemplar();
    DaoLivro daoLivro = new DaoLivro();

    private Exemplar exemplar;
    private Livro livro;

    private Boolean incluindo;

    @FXML
    private void Gravar_click(ActionEvent event) {
        exemplar.setLivro(comboLivro.getSelectionModel().getSelectedItem());

        if (incluindo) {
            dao.inserir(exemplar);
        } else {
            dao.alterar(exemplar);
        }

        preencherTabela();
        editar(false);
        btnIncluir.setStyle(null);
        btnAlterar.setStyle(null);
        btnExcluir.setStyle(null);
    }

    @FXML
    private void incluir_click(ActionEvent event) {
        editar(true);
        preencherCombo();

        incluindo = true;
        livro = new Livro();
        exemplar = new Exemplar();
        comboLivro.requestFocus();
        btnIncluir.setStyle("-fx-background-color: MediumSeaGreen");
        btnExcluir.setStyle(null);
    }

    @FXML
    private void alterar_click(ActionEvent event) {
        editar(true);
        preencherCombo();
        incluindo = true;
        btnAlterar.setStyle("-fx-background-color: Green");
        btnExcluir.setStyle(null);
    }

    @FXML
    private void excluir_click(ActionEvent event) {
        dao.apagar(exemplar);
        preencherTabela();
        btnExcluir.setStyle(null);
    }

    @FXML
    private void keyPressed_teclaSelecionada(KeyEvent event) {
        exibirDados();
    }

    @FXML
    private void valor_Selecionado(MouseEvent event) {
        exibirDados();
    }

    private void editar(boolean habilitar) {
        tabela.setDisable(habilitar);
        comboLivro.setDisable(!habilitar);
        btnRegistrar.setDisable(!habilitar);
        btnAlterar.setDisable(habilitar);
        btnIncluir.setDisable(habilitar);
        btnExcluir.setDisable(habilitar);
    }

    private void exibirDados() {
        this.exemplar = tabela.getSelectionModel().getSelectedItem();
        if (exemplar == null) {
            btnExcluir.setStyle(null);
            return;
        }
        btnExcluir.setStyle("-fx-background-color: Red");
    }

    private void preencherCombo() {
        List<Livro> livros = daoLivro.buscarTodos();
        ObservableList<Livro> data = FXCollections.observableArrayList(livros);
        comboLivro.setItems(data);
    }

    private void preencherTabela() {
        List<Exemplar> exemplares = DaoExemplar.buscarTodosPorid();
        ObservableList<Exemplar> data = FXCollections.observableArrayList(exemplares);
        tabela.setItems(data);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ID.setCellValueFactory(new PropertyValueFactory<Exemplar, Long>("id"));
        coldata.setCellValueFactory(new PropertyValueFactory<Exemplar, LocalDate>("dataAquisicao"));
        colExemplar.setCellValueFactory(new PropertyValueFactory<Livro, String>("titulo"));
        preencherTabela();

    }
}