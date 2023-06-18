package com.example.brocode2;

import Modelll.DAO.DaoPessoa;
import Modelll.Entity.Attendant;
import Modelll.Entity.Technician;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class loginController {
    @FXML
    private Label labelError;

    @FXML
    private TextField idInput;

    @FXML
    private TextField senhaInput;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void loginAtendente(ActionEvent event) throws IOException {
        Attendant user = DaoPessoa.AttendantLogin(Integer.parseInt(idInput.getText()), String.valueOf(senhaInput.getText()));


        if(user == null){
            this.labelError.setText("Credenciais de atendente não encontrados.");
        }else{
            try {
                ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream("user.bin"));
                oos2.writeObject(user);
                oos2.close();
                System.out.println("Usuário salvo em arquivo.");

            } catch (IOException e) {e.printStackTrace();}
            // FAZ A PASSAGEM DE TELA:
            Parent root = FXMLLoader.load(getClass().getResource("atendente.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    public void loginTecnico(ActionEvent event) throws IOException {

        Technician user = DaoPessoa.technicianLogin(Integer.parseInt(idInput.getText()) , String.valueOf(senhaInput.getText()) );

        if(user == null){
            this.labelError.setText("Credenciais de atendente não encontrados.");
        }else{
            try {
                ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream("user.bin"));
                oos2.writeObject(user);
                oos2.close();
                System.out.println("Usuário salvo em arquivo.");

            } catch (IOException e) {e.printStackTrace();}

            // FAZ A PASSAGEM DE TELA:
            System.out.println("chegou aqui");
            Parent root = FXMLLoader.load(getClass().getResource("tecnico.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    public void loginGerente(ActionEvent event) throws IOException {
        Attendant user = DaoPessoa.AttendantLogin(Integer.parseInt(idInput.getText()), String.valueOf(senhaInput.getText()));


        if(user == null){
            this.labelError.setText("Credenciais de gerente não encontrados.");
        }else{
            try {
                ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream("user.bin"));
                oos2.writeObject(user);
                oos2.close();
                System.out.println("Usuário salvo em arquivo.");

            } catch (IOException e) {e.printStackTrace();}
            // FAZ A PASSAGEM DE TELA:
            Parent root = FXMLLoader.load(getClass().getResource("gerente.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
}