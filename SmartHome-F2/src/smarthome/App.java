/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smarthome;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import smarthome.central.ConsolaCentral;
import smarthome.cliente.Cliente;
import smarthome.cliente.Divisao;
import smarthome.ui.VisualizadorEquipamentoFX;

/**
 *
 * @author Danilson
 */
public class App extends Application {

    private BorderPane root;

    @Override
    public void start(Stage primaryStage) throws ErroException {

        //inicializa a borderpane
        this.root = new BorderPane();
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        root.setCenter(grid);

        //cliente
        Cliente cliente = new Cliente("Edson Cazanga", "Barreiro");
        //3 divisao
        Divisao cozinha = new Divisao("Cozinha");
        Divisao sala = new Divisao("Sala");

        //3 lampada para cada divisao
        //adicionar divisao na habitação do cliente
        cliente.getHabitacao().adicionarDivisao(cozinha);
        cliente.getHabitacao().adicionarDivisao(sala);

        //consola
        ConsolaCentral consola = new ConsolaCentral("Securitas AB");

        //adicionar cliente na consola
        consola.adicionarNovoCliente(cliente);

        //abrir e mostrar ao equiapemtno de cliente
        visualizadorEquipamento(root, consola, cliente);

        //scene
        Scene scene = new Scene(root, 880, 620);
        scene.getStylesheets().add(this.getClass().getResource("styles/estilos.css").toExternalForm());

        primaryStage.setTitle("Smart Home");
        primaryStage.getIcons().add(new Image("smarthome/styles/favicon.png"));
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private StackPane visualizadorEquipamento(BorderPane root, ConsolaCentral consola, Cliente cliente) {
        return new VisualizadorEquipamentoFX(root, consola, cliente);
    }

}
