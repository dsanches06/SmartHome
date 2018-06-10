/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smarthome.ui;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import smarthome.central.ConsolaCentral;
import smarthome.cliente.Cliente;

/**
 *
 * @author
 */
public class VisualizadorEquipamentoFX extends StackPane {

    public VisualizadorEquipamentoFX(BorderPane root, ConsolaCentral consola, Cliente cliente) {
        setAlignment(Pos.CENTER);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        //mostra a dashboard
        mostrarEquipamento(root, grid, consola, cliente);
        //posiciona a gridpane no centro da borderpane
        root.setCenter(grid);
    }

    private void mostrarEquipamento(BorderPane root, GridPane grid, ConsolaCentral consola, Cliente cliente) {

        Text titulo = new Text("Visualizar Equipamentos");
        titulo.setId("titulo-text");
        titulo.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(titulo, 0, 0, 2, 1);

        int coluna = 3;
        int contador = 0;
        for (int i = 1; i <= 1; i++) {//linha
            for (int j = 0; j < cliente.getHabitacao().getDivisoes().size(); j++) {
                GridPane box = new GridPane();
                box.setPrefSize(200, 200);
                box.setAlignment(Pos.CENTER);
                box.setStyle("-fx-background-color: black, -fx-control-inner-background; -fx-background-insets: 0, 2; -fx-padding: 2;");

                VBox vbox = new VBox(10);
                Label label = new Label(cliente.getHabitacao().getDivisoes().get(j).getNome());
                Button btn = new Button("Button");
                vbox.getChildren().addAll(label, btn);
                box.getChildren().add(vbox);
                contador++;

                if (contador <= coluna) {
                    GridPane.setConstraints(box, j, i + 2);
                } else {
                    GridPane.setConstraints(box, j - 3, i + 4);
                }
                grid.getChildren().add(box);

            }
        }
    }
}
