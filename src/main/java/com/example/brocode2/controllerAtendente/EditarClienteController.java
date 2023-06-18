package com.example.brocode2.controllerAtendente;

import Modelll.DAO.DaoPessoa;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class EditarClienteController {
    @FXML
    private TextField idInput;
    @FXML
    private TextField nameInput;
    @FXML
    private TextField adressInput;
    @FXML
    private TextField emailInput;
    @FXML
    private Button editarBtn;
    @FXML
    private Button voltarBtn;
    @FXML
    private Label labelConfirmacao;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void telaAtendente(ActionEvent event) throws IOException {
        root = FXMLLoader.load(new File("src/main/resources/com/example/brocode2/atendente.fxml").toURI().toURL());
        //root = FXMLLoader.load(getClass().getResource("atendente.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root,600 , 400);
        stage.setScene(scene);
        stage.show();
    }

    public void editarCliente(ActionEvent event) throws IOException{
        DaoPessoa.editNameClientFile(Integer.parseInt(idInput.getText()),String.valueOf(nameInput.getText()));
        DaoPessoa.editEmailClientFile(Integer.parseInt(idInput.getText()),String.valueOf(emailInput.getText()));
        DaoPessoa.editAdressClientFile(Integer.parseInt(idInput.getText()),String.valueOf(adressInput.getText()));
        //RepositorioPerson.createClient(String.valueOf(nameInput.getText()), String.valueOf((emailInput.getText())),String.valueOf((adressInput.getText())));
        this.labelConfirmacao.setText("Cliente Editado!");
        try {
            DaoPessoa.listClientFile();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }



}