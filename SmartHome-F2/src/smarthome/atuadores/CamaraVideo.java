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
public class CamaraVideo extends Atuador {

    private boolean ligado;
    private static int numEquipamento = 0;
    private int id;
    private String nome;

    public CamaraVideo() {
        super();
        this.id = ++CamaraVideo.numEquipamento;
        this.nome = "CV" + this.id;
        this.ligado = false;
    }

    @Override
    public String toString() {
        String str = "";
        str += "Equipamento: " + nome + "\n";
        str += "Tipo: " + this.getTipo() + "\n";
        str += "Estado: ";
        str += (this.ligado) ? "Ligado\n" : "Desligado\n";
        str += "Modo: ";
        str += (this.isModoAutomatico()) ? "Automático\n" : "Manual\n";
        return str;
    }

    public void ligar() throws ErroException {
        if (this.ligado) {
            throw new ErroException("Esta CMV já se encontra ligado.");
        }//liga a lampada
        this.ligado = true;
        //muda para modo auto
        super.setModoAutomatico(true);
    }

    public void desligar() throws ErroException {
        if (!this.ligado) {
            throw new ErroException("Esta CMV já se encontra desligado.");
        }//desliga a lampada
        this.ligado = false;
         //muda para modo manual
            super.setModoAutomatico(false);
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

}
