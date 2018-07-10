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
import smarthome.central.ConsolaCentral;
import smarthome.cliente.Cliente;
import smarthome.cliente.Divisao;
import smarthome.equipamentos.Equipamento;
import smarthome.sensores.SensorTemperatura;

/**
 *
 * @author
 */
public class ModuloControloTemperatura extends Modulo {

    private String nome;

    public ModuloControloTemperatura(ConsolaCentral consola, String nome) {
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

   // @Override
    public void controlarEquipamento(Cliente cliente, int divisaoId) throws ErroException {
        Divisao divisao = cliente.getHabitacao().getDivisaoPorID(divisaoId);
        if (divisao != null) {
            for (Equipamento sensorTemperatura : divisao.getEquipamentos()) {
                if (Equipamento.instanceOfSensorTemperatura(sensorTemperatura) == true) {
                    //se estiver desligado
                    if (((SensorTemperatura) sensorTemperatura).isLigado() != true) {
                        //liga o sensor
                        ((SensorTemperatura) sensorTemperatura).ligar();
                    }
                    //faz o loop
                    for (Equipamento arCondicionado : divisao.getEquipamentos()) {
                        if (Equipamento.instanceOfArCondicionado(arCondicionado) == true) {
                            //se for maior que 25ºC
                            if (((SensorTemperatura) sensorTemperatura).getTemperatura() >= 25) {
                                //se estiver ligado
                                if (((ArCondicionado) arCondicionado).isLigado() == true) {
                                    //e recebe o valor da temperatura
                                    ((ArCondicionado) arCondicionado).setTemperatura(((SensorTemperatura) sensorTemperatura).getTemperatura());
                                    //desligar o ac 
                                    ((ArCondicionado) arCondicionado).desligar();
                                }
                            } //se for menor que 21ºC
                            else if (((SensorTemperatura) sensorTemperatura).getTemperatura() < 21) {
                                //se estiver desligado
                                if (((ArCondicionado) arCondicionado).isLigado() != true) {
                                    //ligar o ac 
                                    ((ArCondicionado) arCondicionado).ligar();
                                    //e recebe o valor da temperatura
                                    ((ArCondicionado) arCondicionado).setTemperatura(((SensorTemperatura) sensorTemperatura).getTemperatura());
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}
