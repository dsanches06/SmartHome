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
public class Lampada extends Atuador {

    private static int numEquipamento = 0;
    //intensidade igual a zero(minima) - desligado
    public static final int INTENSIDADE_MIN = 0;
    //intensidade igual a 20(maxima)
    public static final int INTENSIDADE_MAX = 20;
    //valor da intensidade
    private int intensidade;
    //estado ligado ou desligado
    private boolean ligado;
    //nome
    private String nome;
    //identificador para cada equipamento
    private int id;

    //Constructor
    public Lampada() {
        super();
        this.id = ++Lampada.numEquipamento;
        this.nome = "L" + this.id;
        this.intensidade = Lampada.INTENSIDADE_MIN;
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
        str += "Intensidade: " + this.intensidade + " kw/h\n";
        return str;
    }

    public void ligar() throws ErroException {
        if (this.ligado) {
            throw new ErroException("Esta lampada já se encontra ligada.");
        }//liga a lampada
        this.ligado = true;
    }

    public void desligar() throws ErroException {
        if (!this.ligado) {
            throw new ErroException("Esta lampada já se encontra desligada.");
        }//desliga a lampada
        this.ligado = false;
    }

    public void regularEquipamento(int valor) throws ErroException {//duvida
        this.intensidade = valor;
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

    public int getIntensidade() {
        return intensidade;
    }

    public void setIntensidade(int intensidade) {
        this.intensidade = intensidade;
    }

    public boolean isLigado() {
        return ligado;
    }

    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    @Override
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
