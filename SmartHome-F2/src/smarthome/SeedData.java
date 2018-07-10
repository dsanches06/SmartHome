/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smarthome;

import smarthome.atuadores.*;
import smarthome.central.*;
import smarthome.cliente.*;
import smarthome.sensores.*;

/**
 *
 * @author
 */
public class SeedData {

    private ConsolaCentral consola;

    public SeedData(ConsolaCentral consola) {
        this.consola = consola;
    }

    public void seedData() {

        Cliente edson = new Cliente("Edson Cazanga", "Setúbal", "M", 4, consola);
        Divisao divisao1 = edson.getHabitacao().getDivisaoPorID(1);
        divisao1.adicionarEquipamento(new Lampada());
        divisao1.adicionarEquipamento(new Tomada());
        divisao1.adicionarEquipamento(new SensorLuminosidade());
        divisao1.adicionarEquipamento(new ArCondicionado());
        divisao1.adicionarEquipamento(new SensorTemperatura());

        Divisao divisao2 = edson.getHabitacao().getDivisaoPorID(2);
        divisao2.adicionarEquipamento(new ArCondicionado());
        divisao2.adicionarEquipamento(new SensorTemperatura());

        Divisao divisao3 = edson.getHabitacao().getDivisaoPorID(3);
        divisao3.adicionarEquipamento(new Sirene());
        divisao3.adicionarEquipamento(new CamaraFotografica());
        divisao3.adicionarEquipamento(new CamaraVideo());
        divisao3.adicionarEquipamento(new SensorMovimento());

        Divisao divisao4 = edson.getHabitacao().getDivisaoPorID(4);
        divisao4.adicionarEquipamento(new Lampada());
        divisao4.adicionarEquipamento(new SensorLuminosidade());
        divisao4.adicionarEquipamento(new Sirene());
        divisao4.adicionarEquipamento(new SensorMovimento());
        

        //adicionar cliente na consola
        consola.adicionarNovoCliente(edson);

    }

}
