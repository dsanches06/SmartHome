/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smarthome.equipamentos;

import smarthome.atuadores.*;
import smarthome.cliente.*;
import smarthome.sensores.*;

/**
 *
 * @author
 */
public abstract class Equipamento {

    // tipo de equipamento
    private TipoEquipamento tipo;
    //divisão onde se encontra o equipamento
    protected Divisao divisao;

    //Constructor
    public Equipamento(TipoEquipamento tipo) {
        this.tipo = tipo;
        this.divisao = null;
    }

    public TipoEquipamento getTipo() {
        return tipo;
    }

    //metodos abstractos
    public abstract int getId();

    public abstract String getNome();

    public abstract void setDivisao(Divisao divisao);

    //metodos estaticos
    public static boolean instanceOfLampada(Equipamento equipamento) {
        return equipamento instanceof Lampada;
    }

    public static boolean instanceOfTomada(Equipamento equipamento) {
        return equipamento instanceof Tomada;
    }

    public static boolean instanceOfSensorLuminosidade(Equipamento equipamento) {
        return equipamento instanceof SensorLuminosidade;
    }

    public static boolean instanceOfArCondicionado(Equipamento equipamento) {
        return equipamento instanceof ArCondicionado;
    }

    public static boolean instanceOfSensorTemperatura(Equipamento equipamento) {
        return equipamento instanceof SensorTemperatura;
    }

    public static boolean instanceOfCamaraFotografica(Equipamento equipamento) {
        return equipamento instanceof CamaraFotografica;
    }

    public static boolean instanceOfCamaraVideo(Equipamento equipamento) {
        return equipamento instanceof CamaraVideo;
    }

    public static boolean instanceOfSirene(Equipamento equipamento) {
        return equipamento instanceof Sirene;
    }

    public static boolean instanceOfSensorMovimento(Equipamento equipamento) {
        return equipamento instanceof SensorMovimento;
    }

    public static boolean instanceOfSensorPortaAberta(Equipamento equipamento) {
        return equipamento instanceof SensorPortaAberta;
    }

}
