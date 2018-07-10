/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smarthome.modulos;

import smarthome.*;
import smarthome.atuadores.*;
import smarthome.central.*;
import smarthome.cliente.*;
import smarthome.equipamentos.*;
import smarthome.sensores.*;

/**
 *
 * @author
 */
public class ModuloControloLuminosidade extends Modulo {

    private String nome;

    public ModuloControloLuminosidade(ConsolaCentral consola, String nome) {
        super(consola);
        this.nome = nome;
    }

    @Override
    public ConsolaCentral getConsola() {
        return super.getConsola();
    }

    @Override
    public String getNome() {
        return nome;
    }

    //@Override
    public void controlarEquipamento(Cliente cliente, int divisaoId, String equipamento) throws ErroException {
        Divisao divisao = cliente.getHabitacao().getDivisaoPorID(divisaoId);
        if (divisao != null) {
            switch (equipamento) {
                case "sensorLuminosidade":
                    for (Equipamento sensorLuminosidade : divisao.getEquipamentos()) {
                        if (Equipamento.instanceOfSensorLuminosidade(sensorLuminosidade) == true) {
                            //se estiver desligado
                            if (((SensorLuminosidade) sensorLuminosidade).isLigado() != true) {
                                //liga o sensor
                                ((SensorLuminosidade) sensorLuminosidade).ligar();
                            }
                            //faz o loop
                            for (Equipamento lampada : divisao.getEquipamentos()) {
                                if (Equipamento.instanceOfLampada(lampada) == true) {
                                    //se for menor ou igual a intensidade maxima
                                    if (((SensorLuminosidade) sensorLuminosidade).getIntensidade() <= Lampada.INTENSIDADE_MAX) {
                                        //se estiver desligado
                                        if (((Lampada) lampada).isLigado() != true) {
                                            //liga 
                                            ((Lampada) lampada).ligar();
                                            //receber o valor do sensor
                                            ((Lampada) lampada).setIntensidade(((SensorLuminosidade) sensorLuminosidade).getIntensidade());
                                        }
                                    } //se for maior que a intensidade maxima
                                    else if (((SensorLuminosidade) sensorLuminosidade).getIntensidade() > Lampada.INTENSIDADE_MAX) {
                                        //se estiver ligado
                                        if (((Lampada) lampada).isLigado() == true) {
                                            //receber o valor do sensor
                                            ((Lampada) lampada).setIntensidade(((SensorLuminosidade) sensorLuminosidade).getIntensidade());
                                            //desliga 
                                            ((Lampada) lampada).desligar();
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                case "tomada":
                    for (Equipamento tomada : divisao.getEquipamentos()) {
                        if (Equipamento.instanceOfTomada(tomada) == true) {
                            //se estiver ligado
                            if (((Tomada) tomada).isLigado() == true) {
                                //desliga 
                                ((Tomada) tomada).desligar();
                            } //se estiver desligado
                            else if (((Tomada) tomada).isLigado() != true) {
                                //liga 
                                ((Tomada) tomada).ligar();
                            }
                        }
                    }
                    break;
            }
        }
    }

}
