package br.edu.femass.gui;

import br.edu.femass.dao.DaoAutor;
import br.edu.femass.model.Autor;
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

public class ControllerAutor implements Initializable {

    @FXML
    private TextField TxtNomeA;

    @FXML
    private TextField TxtSobrenome;

    @FXML
    private TextField TxtNacionalidade;

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
    private TableView<Autor> Tabela = new TableView<Autor>();

    @FXML
    private TableColumn<Autor, String> colNome = new TableColumn<>();
    @FXML
    private TableColumn<Autor, String> colSobrenome = new TableColumn<>();
    @FXML
    private TableColumn<Autor, String> colNac = new TableColumn<>();

    @FXML
    private TableColumn<Autor, Long> ID = new TableColumn<>();

    private DaoAutor dao = new DaoAutor();
    private Autor autor;
    private Boolean incluindo;

    @FXML
    private void Gravar_Click(ActionEvent event) {
        autor.setNome(TxtNomeA.getText());
        autor.setSobrenome(TxtSobrenome.getText());
        autor.setNacionalidade(TxtNacionalidade.getText());

        if (incluindo) {
            dao.inserir(autor);
        } else {
            dao.alterar(autor);
        }

        preencherLista();
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
        autor = new Autor();
        TxtNomeA.setText("");
        TxtSobrenome.setText("");
        TxtNacionalidade.setText("");
        TxtNomeA.requestFocus();
        BtnIncluir.setStyle("-fx-background-color: MediumSeaGreen");
        BtnExcluir.setStyle(null);

    }

    @FXML
    private void excluir_click(ActionEvent event) {
        dao.apagar(autor);
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
        LstAutores.setDisable(habilitar);
        TxtNomeA.setDisable(!habilitar);
        TxtSobrenome.setDisable(!habilitar);
        TxtNacionalidade.setDisable(!habilitar);
        BtnSalvar.setDisable(!habilitar);
        BtnAlterar.setDisable(habilitar);
        BtnIncluir.setDisable(habilitar);
        BtnExcluir.setDisable(habilitar);
    }

    private void exibirDados() {
        this.autor = LstAutores.getSelectionModel().getSelectedItem();
        if (autor == null) {
            BtnExcluir.setStyle(null);
            return;
        }
        BtnExcluir.setStyle("-fx-background-color: Red");
        TxtNomeA.setText(autor.getNome());
        TxtSobrenome.setText(autor.getSobrenome());
        TxtNacionalidade.setText(autor.getNacionalidade());
    }

    private void preencherLista() {
        List<Autor> autores = dao.buscarTodos();

        ObservableList<Autor> data = FXCollections.observableList(autores);
        LstAutores.setItems(data);
    }

    private void preencherTabela() {
        List<Autor> autores = dao.buscarTodosPorid();

        ObservableList<Autor> data = FXCollections.observableList(autores);
        Tabela.setItems(data);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colNome.setCellValueFactory(
                new PropertyValueFactory<Autor, String>("nome"));
        colSobrenome.setCellValueFactory(
                new PropertyValueFactory<Autor, String>("sobrenome"));
        colNac.setCellValueFactory(
                new PropertyValueFactory<Autor, String>("nacionalidade"));
        ID.setCellValueFactory(
                new PropertyValueFactory<Autor, Long>("id"));
        preencherLista();
        preencherTabela();
    }
}