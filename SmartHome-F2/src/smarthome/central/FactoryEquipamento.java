package smarthome.central;

import smarthome.atuadores.*;
import smarthome.equipamentos.*;
import smarthome.sensores.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author
 */
public class FactoryEquipamento {

    public static Equipamento criarEquipamentoAtuador(String tipo) {
        switch (tipo) {
            case "Ar Condicionado":
                return new ArCondicionado();
            case "Camara Fotografica":
                return new CamaraFotografica();
            case "Camara de Video":
                return new CamaraVideo();
            case "Lampada":
                return new Lampada();
            case "Sirene":
                return new Sirene();
            case "Tomada":
                return new Tomada();
        }
        return null;
    }

    public static Equipamento criarEquipamentoSensor(String tipo) {
        switch (tipo) {
            case "Sensor Luminosidade":
                return new SensorLuminosidade();
            case "Sensor Movimento":
                return new SensorMovimento();
            case "Sensor Porta Aberta":
                return new SensorPortaAberta();
            case "Sensor Temperatura":
                return new SensorTemperatura();
        }
        return null;
    }
}
