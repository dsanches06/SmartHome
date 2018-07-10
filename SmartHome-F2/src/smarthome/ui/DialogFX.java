/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smarthome.ui;

import java.util.Optional;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.ImageView;
import smarthome.atuadores.ArCondicionado;
import smarthome.equipamentos.Equipamento;
import smarthome.sensores.SensorLuminosidade;
import smarthome.sensores.SensorTemperatura;

/**
 *
 * @author
 */
public class DialogFX {

    public DialogFX(Equipamento equipamento) {
        TextInputDialog dialog = new TextInputDialog();
//se for sensor temperatura
        if (Equipamento.instanceOfSensorTemperatura(equipamento) == true) {
            dialog.setTitle("Alterar Temperatura Local");
            dialog.setHeaderText("Alterar temperatura do " + ((SensorTemperatura) equipamento).getNome());
            dialog.setContentText("Valor da temperatura ºC");
            // Traditional way to get the response value.
            Optional<String> result = dialog.showAndWait();
            if (result.isPresent()) {
                ((SensorTemperatura) equipamento).setTemperatura(Integer.parseInt(result.get()));
            }
        }//se for sensor luminosidade
        else if (Equipamento.instanceOfSensorLuminosidade(equipamento) == true) {
            dialog.setTitle("Alterar Intensidade Local");
            dialog.setHeaderText("Alterar intensidade do " + ((SensorLuminosidade) equipamento).getNome());
            dialog.setContentText("Valor da itensidade kw/h");
            // Traditional way to get the response value.
            Optional<String> result = dialog.showAndWait();
            if (result.isPresent()) {
                ((SensorLuminosidade) equipamento).setIntensidade(Integer.parseInt(result.get()));
            }
        }

    }

}
