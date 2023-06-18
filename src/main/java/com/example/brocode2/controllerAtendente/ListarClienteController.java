package com.example.brocode2.controllerAtendente;

import Modelll.DAO.DaoPessoa;
import Modelll.Entity.Client;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public  class ListarClienteController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Client> tabelaClientes;
    @FXML
    private TableColumn<Client, Integer> colunaId;
    @FXML
    private TableColumn<Client, String> colunaName;
    @FXML
    private TableColumn<Client, String> colunaAdress;
    @FXML
    private TableColumn<Client, String> colunaEmail;

    private Button voltarBtn;
    @FXML

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<Client>  list =  FXCollections.observableList(Objects.requireNonNull(DaoPessoa.returnlistClientFile()));

        colunaId.setCellValueFactory(new PropertyValueFactory<Client, Integer>("id"));
        colunaName.setCellValueFactory(new PropertyValueFactory<Client, String>("name"));
        colunaAdress.setCellValueFactory(new PropertyValueFactory<Client, String>("adress"));
        colunaEmail.setCellValueFactory(new PropertyValueFactory<Client, String>("email"));

        tabelaClientes.setItems(list);

    }
}