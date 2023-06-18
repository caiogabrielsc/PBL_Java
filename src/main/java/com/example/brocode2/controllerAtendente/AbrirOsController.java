package com.example.brocode2.controllerAtendente;

import Control.RepositorioOs;
import Modelll.Entity.Attendant;
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
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class AbrirOsController {
    @FXML
    private TextField idInput;
    @FXML
    private TextField descricaoInput;
    @FXML
    private Button criarBtn;
    @FXML
    private Button voltarBtn;
    @FXML
    private Label labelConfirmacao;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void telaAtendente(ActionEvent event) throws IOException {
        root = FXMLLoader.load(new File("src/main/resources/com/example/brocode2/atendente.fxml").toURI().toURL());
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root,600 , 400);
        stage.setScene(scene);
        stage.show();
    }


    public void abrirOs(ActionEvent event) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.bin"));
            Attendant user = (Attendant) ois.readObject();
            ois.close();

            RepositorioOs.createOS( user ,Integer.parseInt(idInput.getText()) , String.valueOf(descricaoInput.getText()));

            this.labelConfirmacao.setText("OS aberta!");
            RepositorioOs.listOs();

        } catch (IOException | ClassNotFoundException e) {throw new RuntimeException(e);}

    }
}
