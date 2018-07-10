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

    public void controlarEquipamento(Cliente cliente, int divisaoId) throws ErroException {
        Divisao divisao = cliente.getHabitacao().getDivisaoPorID(divisaoId);
        if (divisao != null) {
            for (Equipamento sensorTemperatura : divisao.getEquipamentos()) {
                if (Equipamento.instanceOfSensorTemperatura(sensorTemperatura) == true) {
                    //liga o sensor
                    ((SensorTemperatura) sensorTemperatura).ligar();
                    //faz o loop
                    for (Equipamento arCondicionado : divisao.getEquipamentos()) {
                        if (Equipamento.instanceOfArCondicionado(arCondicionado) == true) {
                            //se for maior que 25ºC
                            if (((SensorTemperatura) sensorTemperatura).getTemperatura() > 25) {
                                //ligar o ac 
                                ((ArCondicionado) arCondicionado).ligar();
                                //e recebe o valor da temperatura
                                ((ArCondicionado) arCondicionado).setTemperatura(((SensorTemperatura) sensorTemperatura).getTemperatura());
                            } //se for maior que 21ºC
                            else if (((SensorTemperatura) sensorTemperatura).getTemperatura() < 21) {
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

    @Override
    public ConsolaCentral getConsola() {
        return super.getConsola();
    }

    @Override
    public String getNome() {
        return nome;
    }
}
