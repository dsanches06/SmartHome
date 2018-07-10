/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smarthome.modulos;

import java.util.logging.Level;
import java.util.logging.Logger;
import smarthome.ErroException;
import smarthome.atuadores.ArCondicionado;
import smarthome.atuadores.Lampada;
import smarthome.central.ConsolaCentral;
import smarthome.cliente.Cliente;
import smarthome.cliente.Divisao;
import smarthome.equipamentos.Equipamento;
import smarthome.sensores.SensorLuminosidade;
import smarthome.sensores.SensorTemperatura;

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

    public void controlarEquipamento(Cliente cliente, int divisaoId) throws ErroException {
        Divisao divisao = cliente.getHabitacao().getDivisaoPorID(divisaoId);
        if (divisao != null) {
            for (Equipamento sensorLuminosidade : divisao.getEquipamentos()) {
                if (Equipamento.instanceOfSensorLuminosidade(sensorLuminosidade) == true) {
                    //liga o sensor
                    ((SensorLuminosidade) sensorLuminosidade).ligar();
                    //faz o loop
                    for (Equipamento lampada : divisao.getEquipamentos()) {
                        if (Equipamento.instanceOfLampada(lampada) == true) {
                            //se for maior que 25ºC
                            if (((SensorLuminosidade) sensorLuminosidade).getIntensidade() <= Lampada.INTENSIDADE_MIN) {
                                //ligar a lampada
                                ((Lampada) lampada).ligar();
                            } //se for maior que 21ºC
                            else if (((SensorLuminosidade) sensorLuminosidade).getIntensidade() >= Lampada.INTENSIDADE_MAX) {
                                //desligar a lampada
                                ((Lampada) lampada).desligar();
                            }
                        }
                    }
                }

            }
        }
    }

    @Override
    public ConsolaCentral getConsola() {
        return super.getConsola();
    }

    @Override
    public String getNome() {
        return nome;
    }
}
