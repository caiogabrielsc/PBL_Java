package com.example.brocode2.controllerTecnico;

import Control.RepositorioOs;
import Modelll.DAO.DaoOs;
import Modelll.DAO.DaoPessoa;
import Modelll.Entity.Attendant;
import Modelll.Entity.Technician;
import Modelll.Os;
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

import static Modelll.DAO.DaoOs.returnOsById;

public class IniciarOsController {
    @FXML
    private Label labelConfirmacao;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void telaTecnico(ActionEvent event) throws IOException {
        root = FXMLLoader.load(new File("src/main/resources/com/example/brocode2/tecnico.fxml").toURI().toURL());
        //root = FXMLLoader.load(getClass().getResource("atendente.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root,600 , 400);
        stage.setScene(scene);
        stage.show();
    }

    public void iniciarOs(ActionEvent event) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.bin"));
        Technician user = (Technician) ois.readObject();
        ois.close();
        int id =RepositorioOs.startOs(user);
        System.out.println("teste user:" + user.getName());
        if (id != -1){      //se for -1 é pq deu errado, se for != -1
            Os os = returnOsById(id);
            this.labelConfirmacao.setText("Iniciada OS com id ["+ os.getId()+ "] e descrição: \n" + os.getDescription());
        }
        this.labelConfirmacao.setText("Já existe alguma OS em andamento ou não há OS para iniciar.");
    }



}