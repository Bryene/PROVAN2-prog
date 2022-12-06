package br.edu.femass.gui;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

public class ControllerAtendente implements Initializable {

    @FXML
    private void btnCadastrarLeitor(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/GuiLeitor.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/Styles.css");
            scene.getRoot().setStyle("-fx-font-family: 'serif'");
            JOptionPane.showMessageDialog(null, "Bem vindo a tela de Leitor");
            Stage stage = new Stage();
            stage.setTitle("Cadastro");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @FXML
    private void btnCadastrarEmprestimo(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/GuiEmprestimo.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/Styles.css");
            scene.getRoot().setStyle("-fx-font-family: 'serif'");
            JOptionPane.showMessageDialog(null, "Hora de realizar o emprestimo!");
            Stage stage = new Stage();
            stage.setTitle("Realizando emprestimo");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void btnCadastrarDev(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/GuiDev.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/styles/Styles.css");
            scene.getRoot().setStyle("-fx-font-family: 'serif'");
            JOptionPane.showMessageDialog(null, "Vamos devolver!");
            Stage stage = new Stage();
            stage.setTitle("Realizando devolução");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
