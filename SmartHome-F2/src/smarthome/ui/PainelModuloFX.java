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
public class PainelModuloFX extends StackPane {

    public PainelModuloFX(BorderPane root, ConsolaCentral consola, Cliente cliente, String tipoModulo) {
        setAlignment(Pos.TOP_RIGHT);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        //mostra a dashboard
        mostrarDivisao(root, grid, consola, cliente, tipoModulo);
        //posiciona a grid no centro da borderpane
        root.setCenter(grid);
    }

    private void mostrarDivisao(BorderPane root, GridPane grid, ConsolaCentral consola, Cliente cliente, String tipoModulo) {
        switch (tipoModulo) {
            case "alarme":
                painelModuloAlarmeFX(root, grid, consola, cliente);
                break;
            case "luminosidade":
                painelModuloLuminosidadeFX(root, grid, consola, cliente);
                break;
            case "temperatura":
                painelModuloTemperaturaFX(root, grid, consola, cliente);
                break;

        }
    }

    private StackPane painelModuloAlarmeFX(BorderPane root, GridPane grid, ConsolaCentral consola, Cliente cliente) {
        return new PainelModuloAlarmeFX(root, grid, consola, cliente);
    }

    private StackPane painelModuloLuminosidadeFX(BorderPane root, GridPane grid, ConsolaCentral consola, Cliente cliente) {
        return new PainelModuloLuminosidadeFX(root, grid, consola, cliente);
    }

    private StackPane painelModuloTemperaturaFX(BorderPane root, GridPane grid, ConsolaCentral consola, Cliente cliente) {
        return new PainelModuloTemperaturaFX(root, grid, consola, cliente);
    }

}
