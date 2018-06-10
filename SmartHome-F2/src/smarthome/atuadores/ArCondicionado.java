/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smarthome.atuadores;

import smarthome.ErroException;
import smarthome.cliente.*;

/**
 *
 * @author
 */
public class ArCondicionado extends Atuador {

    //temperatura minima 16ºC
    public static final int TEMPERATURA_MIN = 16;
    //temperatura maxima 28ºC
    public static final int TEMPERATURA_MAX = 28;
    //valor da temperatura
    private int temperatura;
    //estado ligado ou desligado
    private boolean ligado;
    //nome
    private String nome;
    //
    private static int numEquipamento = 0;
    //identificador para cada equipamento
    private int id;

    //Constructor
    public ArCondicionado() {
        super();
        this.id = ++ArCondicionado.numEquipamento;
        this.nome = "AC" + this.id;
        this.temperatura = ArCondicionado.TEMPERATURA_MIN;
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
        str += "Temperatura: " + this.temperatura + " ºC\n";
        return str;
    }

    public void ligar() throws ErroException {
        if (this.ligado) {
            throw new ErroException("Esta AC já se encontra ligado.");
        }//liga a lampada
        this.ligado = true;
    }

    public void desligar() throws ErroException {
        if (!this.ligado) {
            throw new ErroException("Esta AC já se encontra desligado.");
        }//desliga a lampada
        this.ligado = false;
    }

    public void regularEquipamento(int valor) throws ErroException {//duvida
        this.temperatura = valor;
    }

    @Override
    public boolean isModoAutomatico() {
        return super.isModoAutomatico();
    }

    @Override
    public void setModoAutomatico(boolean modoAutomatico) {
        super.setModoAutomatico(modoAutomatico);
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int getId() {
        return id;
    }

}
