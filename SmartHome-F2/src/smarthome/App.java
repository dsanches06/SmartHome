/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smarthome;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Danilson
 */
public class App extends Application {
    
    private BorderPane root;


    @Override
    public void start(Stage primaryStage) {

        //inicializa a borderpane
        this.root = new BorderPane();
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
    
}
