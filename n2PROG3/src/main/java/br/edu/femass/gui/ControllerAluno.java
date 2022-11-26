package br.edu.femass.gui;

import br.edu.femass.dao.DaoAluno;
import br.edu.femass.model.Aluno;
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

public class ControllerAluno implements Initializable {

    @FXML
    private TextField TxtNome;

    @FXML
    private TextField TxtEndereco;

    @FXML
    private TextField TxtTelefone;
    @FXML
    private TextField TxtMatricula;
    @FXML
    private ListView<Aluno> LstAlunos;

    @FXML
    private Button BtnSalvar;

    @FXML
    private Button BtnIncluir;

    @FXML
    private Button BtnAlterar;

    @FXML
    private Button BtnExcluir;

    @FXML
    private Button refreshButton;

    @FXML
    private TableView<Aluno> Tabela = new TableView<Aluno>();

    @FXML
    private TableColumn<Aluno, String> colNome = new TableColumn<>();

    @FXML
    private TableColumn<Aluno, String> colEnd = new TableColumn<>();

    @FXML
    private TableColumn<Aluno, String> colTel = new TableColumn<>();

    @FXML
    private TableColumn<Aluno, String> colMatri = new TableColumn<>();

    @FXML
    private TableColumn<Aluno, Long> ID = new TableColumn<>();

    private DaoAluno dao = new DaoAluno();
    private Aluno aluno;
    private Boolean incluindo;

    @FXML
    private void Gravar_Click(ActionEvent event) {
        aluno.setNome(TxtNome.getText());
        aluno.setEndereco(TxtEndereco.getText());
        aluno.setTelefone(TxtTelefone.getText());
        aluno.setMatricula(TxtMatricula.getText());

        if (incluindo) {
            dao.inserir(aluno);
        } else {
            dao.alterar(aluno);
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
        BtnAlterar.setStyle("-fx-background-color: Yellow");
        BtnExcluir.setStyle(null);
    }

    @FXML
    private void incluir_click(ActionEvent event) {
        editar(true);
        incluindo = true;
        aluno = new Aluno();
        TxtEndereco.setText("");
        TxtNome.setText("");
        TxtNome.requestFocus();
        BtnIncluir.setStyle("-fx-background-color: MediumSeaGreen");
        BtnExcluir.setStyle(null);

    }

    @FXML
    private void excluir_click(ActionEvent event) {
        dao.apagar(aluno);
        preencherLista();
        BtnExcluir.setStyle(null);
    }

    @FXML
    private void recarregar_click(ActionEvent event) {
        preencherLista();
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
        LstAlunos.setDisable(habilitar);
        TxtEndereco.setDisable(!habilitar);
        TxtNome.setDisable(!habilitar);
        TxtTelefone.setDisable(!habilitar);
        TxtMatricula.setDisable(!habilitar);
        BtnSalvar.setDisable(!habilitar);
        BtnAlterar.setDisable(habilitar);
        BtnIncluir.setDisable(habilitar);
        BtnExcluir.setDisable(habilitar);
    }

    private void exibirDados() {
        this.aluno = LstAlunos.getSelectionModel().getSelectedItem();
        if (aluno == null) {
            BtnExcluir.setStyle(null);
            return;
        }
        BtnExcluir.setStyle("-fx-background-color: Red");
        TxtNome.setText(aluno.getNome());
        TxtEndereco.setText(aluno.getEndereco());
    }

    private void preencherLista() {
        List<Aluno> alunos = dao.buscarTodos();

        ObservableList<Aluno> data = FXCollections.observableList(alunos);
        LstAlunos.setItems(data);
    }

    private void preencherTabela() {
        List<Aluno> alunos = dao.buscarTodosPorid();

        ObservableList<Aluno> data = FXCollections.observableList(alunos);
        Tabela.setItems(data);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ID.setCellValueFactory(
                new PropertyValueFactory<Aluno, Long>("id"));
        colNome.setCellValueFactory(
                new PropertyValueFactory<Aluno, String>("nome"));
        colEnd.setCellValueFactory(
                new PropertyValueFactory<Aluno, String>("endereco"));
        colTel.setCellValueFactory(
                new PropertyValueFactory<Aluno, String>("telefone"));
        colMatri.setCellValueFactory(
                new PropertyValueFactory<Aluno, String>("matricula"));

        preencherLista();
        preencherTabela();
    }
}
