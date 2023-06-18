package com.example.brocode2;

import Control.RepositorioPerson;
import Modelll.DAO.DaoOs;
import Modelll.DAO.DaoProdutoServico;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException, ClassNotFoundException {

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600 , 400);
        stage.setTitle("Sistema");
        stage.setScene(scene);
        stage.show();


        if(DaoProdutoServico.retornarListaProduto().isEmpty()){DaoProdutoServico.fillArraylistProduto();}
        if(DaoProdutoServico.retornarListaServico().isEmpty()){DaoProdutoServico.fillArraylistService();}



    }
    public static void main(String[] args) {
        launch();
    }
}