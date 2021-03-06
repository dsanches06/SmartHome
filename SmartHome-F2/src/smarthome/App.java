/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smarthome;

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import smarthome.central.*;
import smarthome.ui.*;

/**
 *
 * @author
 */
public class App extends Application {

    public static Stage stage;

    @Override
    public void start(Stage primaryStage) throws ErroException {

        //cria a borderpane
        BorderPane root = new BorderPane();
        //cria a consola central por omisssão
        ConsolaCentral consola = new ConsolaCentral();
        //cria a classe para carregar clientes
        SeedData data = new SeedData(consola);
        //insere os dados por omissao
        data.seedData();
        //mostra o painel consola central
        consolaCentralFX(root, consola);

        //scene
        Scene scene = new Scene(root, 880, 550);
        scene.getStylesheets().add(this.getClass().getResource("styles/estilos.css").toExternalForm());

        primaryStage.setTitle("Smart Home");
        primaryStage.getIcons().add(new Image("smarthome/styles/favicon.png"));
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
        stage = primaryStage;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private StackPane consolaCentralFX(BorderPane root, ConsolaCentral consola) {
        return new PainelConsolaCentralFX(root, consola);
    }

}
