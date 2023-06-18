package com.example.brocode2.controllerAtendente;

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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class PagamentoOsController implements Initializable {

    @FXML
    private TextField idInput;
    @FXML
    private Label welcomeText;
    @FXML
    private TextField pagamentoInput;
    @FXML
    private TextField satisfacaoInput;
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

    public void telaAtendente(ActionEvent event) throws IOException {
        root = FXMLLoader.load(new File("src/main/resources/com/example/brocode2/atendente.fxml").toURI().toURL());
        //root = FXMLLoader.load(getClass().getResource("atendente.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root,600 , 400);
        stage.setScene(scene);
        stage.show();
    }

    public void gerarPagamento(ActionEvent event) throws IOException, ClassNotFoundException {
        int idOs = Integer.parseInt(idInput.getText());
        String pagamento = String.valueOf(pagamentoInput.getText());
        int satisfacao = Integer.parseInt(satisfacaoInput.getText());

        DaoOs.paymantOsDaoFile(idOs,pagamento,satisfacao);

        welcomeText.setText("OS completa,o valor total para pagamento da OS foi :" + DaoOs.returnOsById(idOs).getFinalvalue()+". Vá ao caixa para pagar!");

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