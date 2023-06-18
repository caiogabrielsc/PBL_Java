package com.example.brocode2.controllerTecnico;

import Control.RepositorioOs;
import Modelll.DAO.DaoProdutoServico;
import Modelll.Entity.Technician;
import Modelll.Os;
import Modelll.Produto;
import Modelll.Servico;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class FinalizarOsController implements Initializable {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField inputIdF;
    @FXML
    private TableView<Produto> tableProduto;
    @FXML
    private TableColumn<Produto, Integer> colunaIdP;
    @FXML
    private TableColumn<Produto, String> colunaNomeP;
    @FXML
    private TableColumn<Produto, Integer> colunaEstoqueP;
    @FXML
    private TableColumn<Produto, Integer> colunaValorP;

    @FXML
    private TableView<Servico> tableServico;
    @FXML
    private TableColumn<Servico, Integer> colunaIdS;
    @FXML
    private TableColumn<Servico, String> colunaNomeS;
    @FXML
    private TableColumn<Servico, Integer> colunaValorS;


    private Stage stage;
    private Scene scene;
    private Parent root;

    public void telaTecnico(ActionEvent event) throws IOException {
        root = FXMLLoader.load(new File("src/main/resources/com/example/brocode2/tecnico.fxml").toURI().toURL());
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root,600 , 400);
        stage.setScene(scene);
        stage.show();
    }

    public void finalizarOsProduto(ActionEvent event) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.bin"));
        Technician user = (Technician) ois.readObject();
        ois.close();

        int osId = RepositorioOs.finalizeOS(user,Integer.parseInt((inputIdF).getText()),"produto");

        if ( osId !=  -1) {      // deu certo
            this.welcomeText.setText("Finalizada OS com id ["+ osId +  "].");
        }else {this.welcomeText.setText("Não é possível finalizar alguma OS.");} //deu errado
    }

    public void finalizarOsServico(ActionEvent event) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.bin"));
        Technician user = (Technician) ois.readObject();
        ois.close();

        int osId = RepositorioOs.finalizeOS(user,Integer.parseInt(inputIdF.getText()),"servico");

        if ( osId !=  -1) {      // deu certo
            this.welcomeText.setText("Finalizada OS com id ["+ osId +  "].");
        }else {this.welcomeText.setText("Não é possível finalizar alguma OS.");} //deu errado
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<Produto> plist = null;
        try {
            plist = FXCollections.observableList(Objects.requireNonNull(DaoProdutoServico.retornarListaProduto()));
        } catch (IOException e) {throw new RuntimeException(e);} catch (ClassNotFoundException e) {throw new RuntimeException(e);}

        colunaIdP.setCellValueFactory(new PropertyValueFactory<Produto, Integer>("id"));
        colunaNomeP.setCellValueFactory(new PropertyValueFactory<Produto, String>("name"));
        colunaValorP.setCellValueFactory(new PropertyValueFactory<Produto, Integer>("value"));
        colunaEstoqueP.setCellValueFactory(new PropertyValueFactory<Produto, Integer>("qtd"));

        tableProduto.setItems(plist);


        ObservableList<Servico> slist = null;
        try {
            slist = FXCollections.observableList(Objects.requireNonNull(DaoProdutoServico.retornarListaServico()));
        } catch (IOException e) {throw new RuntimeException(e);} catch (ClassNotFoundException e) {throw new RuntimeException(e);}

        colunaIdS.setCellValueFactory(new PropertyValueFactory<Servico, Integer>("id"));
        colunaNomeS.setCellValueFactory(new PropertyValueFactory<Servico, String>("name"));
        colunaValorS.setCellValueFactory(new PropertyValueFactory<Servico, Integer>("value"));
        tableServico.setItems(slist);

    }
}