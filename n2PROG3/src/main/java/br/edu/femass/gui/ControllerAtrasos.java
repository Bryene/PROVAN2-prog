package br.edu.femass.gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.femass.dao.DaoEmprestimo;
import br.edu.femass.model.Emprestimo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class ControllerAtrasos implements Initializable {
    @FXML
    private ListView<Emprestimo> LstAtrasos;

    DaoEmprestimo daoEmprestimo = new DaoEmprestimo();

    private void preencherLista() {
        List<Emprestimo> emprestimos = daoEmprestimo.buscarTodos();
        ObservableList<Emprestimo> data = FXCollections.observableList(emprestimos);
        LstAtrasos.setItems(data);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        preencherLista();
    }
}
