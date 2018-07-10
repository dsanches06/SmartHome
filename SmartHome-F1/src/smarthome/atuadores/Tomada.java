/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smarthome.atuadores;

import smarthome.*;
import smarthome.cliente.*;

/**
 *
 * @author
 */
public class Tomada extends Atuador {

    private boolean ligado;
    private boolean wifi;
    private static int numEquipamento = 0;
    private int id;
    private String nome;

    public Tomada() {
        super();
        this.id = ++Tomada.numEquipamento;
        this.nome = "TM" + this.id;
        this.ligado = false;
        this.wifi = false;
    }

    @Override
    public String toString() {
        String str = "";
        str += "Equipamento: " + nome + "\n";
        str += "Tipo: " + this.getTipo() + "\n";
        str += "Modo: ";
        str += (this.isModoAutomatico()) ? "Automático\n" : "Manual\n";
        str += "Estado: ";
        str += (this.ligado) ? "Ligado\n" : "Desligado\n";
        str += "Wi-Fi: ";
        str += (this.wifi) ? "Activo\n" : "Desativo\n";
        return str;
    }

    public void ligar() throws ErroException {
        if (this.ligado) {
            throw new ErroException("Esta TMD já se encontra ligado.");
        }//liga a lampada
        this.ligado = true;
        //muda para modo auto
        super.setModoAutomatico(true);
        //ativa wi-fi
        this.wifi = true;
    }

    public void desligar() throws ErroException {
        if (!this.ligado) {
            throw new ErroException("Esta TMD já se encontra desligado.");
        }//desliga a lampada
        this.ligado = false;
        //muda para modo manual
        super.setModoAutomatico(false);
        //desativa wi-fi
        this.wifi = false;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setDivisao(Divisao divisao) {
        this.divisao = divisao;
    }

    @Override
    public String getNome() {
        return nome;
    }

    public boolean isLigado() {
        return ligado;
    }

    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

}
