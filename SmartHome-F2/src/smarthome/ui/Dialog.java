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
import smarthome.sensores.SensorTemperatura;

/**
 *
 * @author
 */
public class Dialog {

    public Dialog(Equipamento equipamento) {
        TextInputDialog dialog = new TextInputDialog();

        if (Equipamento.instanceOfSensorTemperatura(equipamento) == true) {
            dialog.setTitle("Alterar Temperatura Local");
            dialog.setHeaderText("Alterar temperatura do " + ((SensorTemperatura) equipamento).getNome());
            dialog.setContentText("Valor da temperatura");
            // Traditional way to get the response value.
            Optional<String> result = dialog.showAndWait();
            if (result.isPresent()) {
                ((SensorTemperatura) equipamento).setTemperatura(Integer.parseInt(result.get()));
            }
        }

    }

}
