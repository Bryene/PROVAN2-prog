package br.edu.femass.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.femass.dao.DaoAutor;
import br.edu.femass.dao.DaoLivro;
import br.edu.femass.model.Autor;
import br.edu.femass.model.Livro;

public class Controllerlivro implements Initializable {

    @FXML
    private TextField TxtTitulolivro;

    @FXML
    private ListView<Livro> LstLivros;

    @FXML
    private ListView<Autor> LstAutores;

    @FXML
    private Button BtnSalvar;

    @FXML
    private Button BtnIncluir;

    @FXML
    private Button BtnAlterar;

    @FXML
    private Button BtnExcluir;

    @FXML
    private TableView<Livro> Tabela = new TableView<Livro>();

    @FXML
    private TableColumn<Livro, String> colTitulo = new TableColumn<>();

    @FXML
    private TableColumn<Livro, Long> ID = new TableColumn<>();

    private DaoLivro dao = new DaoLivro();
    private Livro livro;
    private Boolean incluindo;

    @FXML
    private void Gravar_Click(ActionEvent event) {
        livro.setTitulo(TxtTitulolivro.getText());

        if (incluindo) {
            dao.inserir(livro);
        } else {
            dao.alterar(livro);
        }

        preencherLista();
        preencherAutores();
        preencherTabela();
        editar(false);
        BtnIncluir.setStyle(null);
        BtnAlterar.setStyle(null);
        BtnExcluir.setStyle(null);
    }

    @FXML
    private void altera_click(ActionEvent event) {
        editar(true);
        incluindo = true;
        BtnAlterar.setStyle("-fx-background-color: Green");
        BtnExcluir.setStyle(null);
    }

    @FXML
    private void incluir_click(ActionEvent event) {
        editar(true);
        incluindo = true;
        livro = new Livro();
        TxtTitulolivro.setText("");
        TxtTitulolivro.requestFocus();
        BtnIncluir.setStyle("-fx-background-color: MediumSeaGreen");
        BtnExcluir.setStyle(null);

    }

    @FXML
    private void excluir_click(ActionEvent event) {
        dao.apagar(livro);
        preencherLista();
        BtnExcluir.setStyle(null);
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
        LstLivros.setDisable(habilitar);
        TxtTitulolivro.setDisable(!habilitar);
        BtnSalvar.setDisable(!habilitar);
        BtnAlterar.setDisable(habilitar);
        BtnIncluir.setDisable(habilitar);
        BtnExcluir.setDisable(habilitar);
    }

    private void exibirDados() {
        this.livro = LstLivros.getSelectionModel().getSelectedItem();
        if (livro == null) {
            BtnExcluir.setStyle(null);
            return;
        }
        BtnExcluir.setStyle("-fx-background-color: Red");
        TxtTitulolivro.setText(livro.getTitulo());

    }

    private void preencherLista() {
        List<Livro> livros = dao.buscarTodos();

        ObservableList<Livro> data = FXCollections.observableList(livros);
        LstLivros.setItems(data);
    }

    private void preencherTabela() {
        List<Livro> livros = dao.buscarTodosPorid();

        ObservableList<Livro> data = FXCollections.observableList(livros);
        Tabela.setItems(data);
    }

    private void preencherAutores() {
        List<Autor> autores = DaoAutor.buscarTodos();
        ObservableList<Autor> data = FXCollections.observableArrayList(autores);
        // cbAutor.setItems(data);
        LstAutores.setItems(data);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colTitulo.setCellValueFactory(
                new PropertyValueFactory<Livro, String>("titulo"));

        ID.setCellValueFactory(
                new PropertyValueFactory<Livro, Long>("id"));
        preencherLista();
        preencherTabela();
        preencherAutores();
    }
}
