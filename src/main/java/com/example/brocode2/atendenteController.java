package com.example.brocode2;

import Control.RepositorioOs;
import Modelll.DAO.DaoOs;
import Modelll.DAO.DaoPessoa;
import Modelll.Entity.Attendant;
import Modelll.Entity.Client;
import Modelll.Os;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.*;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class atendenteController implements Initializable {
    @FXML
    private Label welcomeText;
    @FXML
    private TableView<Os> tabelaOs;
    @FXML
    private TableColumn<Os, Integer> colunaId;
    @FXML
    private TableColumn<Os, String> colunaCliente;
    @FXML
    private TableColumn<Os, Integer> colunaStatus;
    @FXML
    private TableColumn<Os, String> colunaDescricao;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void telaLogin(ActionEvent event) throws IOException {
        System.out.println("button pressed");
        root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600 , 400);
        stage.setScene(scene);
        stage.show();
    }

    public void criarCliente(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("viewAtendente/criarCliente.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600 , 400);
        stage.setScene(scene);
        stage.show();
    }

    public void editarCliente(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("viewAtendente/editarCliente.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600 , 400);
        stage.setScene(scene);
        stage.show();
    }

    public void listarCliente(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("viewAtendente/listarCliente.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600 , 400);
        stage.setScene(scene);
        stage.show();
    }

    public void abrirOs(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("viewAtendente/abrirOs.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600 , 400);
        stage.setScene(scene);
        stage.show();

        /*
        try {
            RepositorioOs.listOs();
        } catch (ClassNotFoundException e) {throw new RuntimeException(e);}

         */

    }

    public void editarOs(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("viewAtendente/editarOS.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600 , 400);
        stage.setScene(scene);
        stage.show();
    }

    public void cancelarOs(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("viewAtendente/cancelarOS.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600 , 400);
        stage.setScene(scene);
        stage.show();
    }

    public void pagamentoOs(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("viewAtendente/pagamentoOS.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600 , 400);
        stage.setScene(scene);
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.bin"));
            Attendant user = (Attendant) ois.readObject();
            ois.close();
            welcomeText.setText("Bem vindo(a) de volta " + user.getName() + ".");
        } catch (IOException | ClassNotFoundException e) {throw new RuntimeException(e);}


        ObservableList<Os> osList = null;
        try {
            osList = FXCollections.observableList(Objects.requireNonNull(DaoOs.returnListOsFile()));
        } catch (IOException e) {throw new RuntimeException(e);} catch (ClassNotFoundException e) {throw new RuntimeException(e);}

            colunaId.setCellValueFactory(new PropertyValueFactory<Os, Integer>("id"));
            //colunaCliente.setCellValueFactory(new PropertyValueFactory<Os, String>("client"));
            colunaCliente.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Os, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Os, String> param) {
                Client client = (Client) param.getValue().getClient();
                String name = (client != null) ? client.getName() : "";
                return new SimpleStringProperty(name);}});
            colunaStatus.setCellValueFactory(new PropertyValueFactory<Os, Integer>("status"));
            colunaDescricao.setCellValueFactory(new PropertyValueFactory<Os, String>("description"));

            tabelaOs.setItems(osList);

    }


}