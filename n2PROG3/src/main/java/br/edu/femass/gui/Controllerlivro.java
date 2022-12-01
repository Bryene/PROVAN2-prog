package br.edu.femass.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
    ComboBox<Autor> ComboBoxAutores;
    // private ListView<Autor> LstAutores;

    @FXML
    private Button BtnSalvar;
    @FXML
    private Button BtnSalvarautor;

    @FXML
    private Button BtnIncluir;

    @FXML
    private Button BtnAlterar;

    @FXML
    private Button BtnExcluir;

    private DaoLivro dao = new DaoLivro();
    private DaoAutor daoAutor = new DaoAutor();
    private Livro livro;
    private Livro autor;
    private Boolean incluindo;

    @FXML
    private void Gravar_Click(ActionEvent event) {
        livro.setTitulo(TxtTitulolivro.getText());
        livro.setAutores(ComboBoxAutores.getSelectionModel().getSelectedItem());

        if (incluindo) {
            dao.inserir(livro);
        } else {
            dao.alterar(livro);
        }

        preencherLista();
        preencherCombo();
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
        ComboBoxAutores.setValue(null);
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
        ComboBoxAutores.setDisable(!habilitar);
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
        ComboBoxAutores.setValue(livro.getAutores());

    }

    private void preencherCombo() {
        List<Autor> autores = daoAutor.buscarTodos();
        ObservableList<Autor> data2 = FXCollections.observableArrayList(autores);
        ComboBoxAutores.setItems(data2);
    }

    private void preencherLista() {
        List<Livro> livros = dao.buscarTodos();
        ObservableList<Livro> data = FXCollections.observableList(livros);
        LstLivros.setItems(data);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        preencherLista();
        preencherCombo();
    }
}
