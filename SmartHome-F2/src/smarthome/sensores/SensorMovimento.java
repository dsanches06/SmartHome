/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smarthome.sensores;

import smarthome.*;
import smarthome.cliente.*;

/**
 *
 * @author
 */
public class SensorMovimento extends Sensor {

    private boolean ligado;
    private boolean movimento;
    private static int numEquipamento = 0;
    private int id;
    private String nome;

    public SensorMovimento() {
        super();
        this.id = ++SensorMovimento.numEquipamento;
        this.nome = "SM" + this.id;
        this.ligado = false;
        this.movimento = false;
    }

    @Override
    public String toString() {
        String str = "";
        str += "Equipamento: " + nome + "\n";
        str += "Tipo: " + this.getTipo() + "\n";
        str += "Estado: ";
        str += (this.ligado) ? "Ligado\n" : "Desligado\n";
        str += "Movimento: ";
        str += (this.movimento) ? "Sim\n" : "N/A\n";
        return str;
    }

    public void ligar() throws ErroException {
        if (this.ligado) {
            throw new ErroException("Esta sensor de movimento já se encontra ligado.");
        }//liga a lampada
        this.ligado = true;
    }

    public void desligar() throws ErroException {
        if (!this.ligado) {
            throw new ErroException("Esta sensor de movimento já se encontra desligado.");
        }//desliga a lampada
        this.ligado = false;
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
        return id;
    }

    @Override
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isMovimento() {
        return movimento;
    }

    public void setMovimento(boolean movimento) {
        this.movimento = movimento;
    }

}
