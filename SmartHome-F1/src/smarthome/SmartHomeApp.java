/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smarthome;

import java.io.*;
import smarthome.atuadores.*;
import smarthome.central.*;
import smarthome.cliente.*;
import smarthome.sensores.*;

/**
 *
 * @author
 */
public class SmartHomeApp {

    /**
     * @param args the command line arguments
     * @throws smarthome.ErroException
     */
    public static void main(String[] args) throws ErroException, IOException {
        // TODO code application logic here
        //consola
        ConsolaCentral consola = new ConsolaCentral();
        //cliente
        Cliente edson = new Cliente("Edson Cazanga", "Setúbal", "M", 4, consola);
        //adicionar cliente na consola
        consola.adicionarNovoCliente(edson);

        Lampada lampada1 = new Lampada();
        Tomada tomada1 = new Tomada();
        SensorLuminosidade sensorLuminosidade1 = new SensorLuminosidade();
        ArCondicionado arCondicionado1 = new ArCondicionado();
        SensorTemperatura sensorTemperatura1 = new SensorTemperatura();

        Divisao divisao1 = edson.getHabitacao().getDivisaoPorID(1);
        divisao1.adicionarEquipamento(lampada1);
        divisao1.adicionarEquipamento(tomada1);
        divisao1.adicionarEquipamento(sensorLuminosidade1);
        divisao1.adicionarEquipamento(arCondicionado1);
        divisao1.adicionarEquipamento(sensorTemperatura1);

        Tomada tomada2 = new Tomada();
        ArCondicionado arCondicionado2 = new ArCondicionado();
        SensorTemperatura sensorTemperatura2 = new SensorTemperatura();

        Divisao divisao2 = edson.getHabitacao().getDivisaoPorID(2);
        divisao2.adicionarEquipamento(arCondicionado2);
        divisao2.adicionarEquipamento(sensorTemperatura2);
        divisao2.adicionarEquipamento(tomada2);

        Sirene sirene1 = new Sirene();
        CamaraFotografica camaraFotografica1 = new CamaraFotografica();
        CamaraVideo camaraVideo1 = new CamaraVideo();
        SensorMovimento sensorMovimento1 = new SensorMovimento();

        Divisao divisao3 = edson.getHabitacao().getDivisaoPorID(3);
        divisao3.adicionarEquipamento(sirene1);
        divisao3.adicionarEquipamento(camaraFotografica1);
        divisao3.adicionarEquipamento(camaraVideo1);
        divisao3.adicionarEquipamento(sensorMovimento1);

        Lampada lampada2 = new Lampada();
        SensorLuminosidade sensorLuminosidade2 = new SensorLuminosidade();
        Sirene sirene2 = new Sirene();
        SensorMovimento sensorMovimento2 = new SensorMovimento();

        Divisao divisao4 = edson.getHabitacao().getDivisaoPorID(4);
        divisao4.adicionarEquipamento(lampada2);
        divisao4.adicionarEquipamento(sensorLuminosidade2);
        divisao4.adicionarEquipamento(sirene2);
        divisao4.adicionarEquipamento(sensorMovimento2);

        //modulo alarme
        consola.getModuloAlarme().controlarEquipamento(edson, 1);
        consola.getModuloAlarme().controlarEquipamento(edson, 2);
        consola.getModuloAlarme().controlarEquipamento(edson, 4);

        //modulo luminosidade
        divisao1.adicionarEquipamento(lampada1);
        divisao1.adicionarEquipamento(tomada1);
        divisao1.adicionarEquipamento(sensorLuminosidade1);
        divisao1.adicionarEquipamento(arCondicionado1);
        divisao1.adicionarEquipamento(sensorTemperatura1);

        consola.getModuloControloLuminosidade().controlarEquipamento(edson, 1, "tomada");
        consola.getModuloControloLuminosidade().controlarEquipamento(edson, 2, "tomada");

        sensorLuminosidade1.setIntensidade(10);
        consola.getModuloControloLuminosidade().controlarEquipamento(edson, 1, "sensorLuminosidade");
        sensorLuminosidade2.setIntensidade(14);
        consola.getModuloControloLuminosidade().controlarEquipamento(edson, 4, "sensorLuminosidade");

        //modulo temperatura
        sensorTemperatura1.setTemperatura(18);
        consola.getModuloControloTemperatura().controlarEquipamento(edson, 1);
        sensorTemperatura2.setTemperatura(20);
        consola.getModuloControloTemperatura().controlarEquipamento(edson, 2);

        //gravar ficheiro
        consola.gravarFicheiro();
        
        //mostrar clientes na consola
        System.out.println(consola.toString());

    }

}
