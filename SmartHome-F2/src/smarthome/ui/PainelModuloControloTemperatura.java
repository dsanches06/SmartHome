/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smarthome.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import smarthome.central.ConsolaCentral;
import smarthome.cliente.Cliente;

/**
 *
 * @author
 */
public class PainelModuloControloTemperatura extends StackPane {

    public PainelModuloControloTemperatura(BorderPane root, ConsolaCentral consola, Cliente cliente, int divisaoId) {

        setAlignment(Pos.TOP_RIGHT);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        //mostra a dashboard
        controlarModuloTemperatura(root, grid, consola, cliente, divisaoId);
        //posiciona a grid no centro da borderpane
        root.setCenter(grid);
    }

    private void controlarModuloTemperatura(BorderPane root, GridPane grid, ConsolaCentral consola, Cliente cliente, int divisaoId) {

    }
}
