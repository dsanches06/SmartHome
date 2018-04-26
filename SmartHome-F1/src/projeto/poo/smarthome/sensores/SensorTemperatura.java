/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.poo.smarthome.sensores;

import projeto.poo.smarthome.cliente.Divisao;
import projeto.poo.smarthome.equipamentos.TipoEquipamento;

/**
 *
 * @author
 */
public class SensorTemperatura extends Sensor {

    //estado ligado ou desligado
    private boolean ligado;

    public SensorTemperatura(TipoEquipamento tipo) {
        super(tipo);
        this.ligado = false;
    }

    public int getTemperatura() {
        if (this.divisao != null) {
            ligar();//ligar o sensor
            return divisao.getTemperatura();
        }
        return 0;
    }

    @Override
    public void ligar() {
        //se estiver desligado
        if (!ligado) {
            //liga o sensor
            this.ligado = true;
        }
    }

    @Override
    public void desligar() {
        //se estiver ligado
        if (ligado) {
            //desliga o sensor
            this.ligado = false;
        }
    }

    @Override
    public void setDivisao(Divisao divisao) {
        this.divisao = divisao;
    }

    public boolean isLigado() {
        return ligado;
    }

    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    @Override
    public int getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
