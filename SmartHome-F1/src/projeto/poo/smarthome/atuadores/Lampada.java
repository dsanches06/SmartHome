/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.poo.smarthome.atuadores;

import projeto.poo.smarthome.cliente.*;
import projeto.poo.smarthome.equipamentos.*;

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
    public Lampada(TipoEquipamento tipo, int intensidade) {
        super(tipo);
        this.id = gerarID();
        this.nome = "Lampada" + this.id;
        if (isIntensidadeValido(intensidade)) {
            this.intensidade = intensidade;
        } else {
            this.intensidade = Lampada.INTENSIDADE_MIN;
        }
        this.ligado = false;
    }

    @Override
    public void ligar() {
        //se estiver desligado
        if (!ligado) {
            //liga a lampada
            this.ligado = true;
        }
    }

    @Override
    public void desligar() {
        //se estiver ligado
        if (ligado) {
            //desliga a lampada
            this.ligado = false;
        }
    }

    private boolean isIntensidadeValido(int valor) {
        return (valor >= Lampada.INTENSIDADE_MIN) && (valor <= Lampada.INTENSIDADE_MAX);
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

    private int gerarID() {
        return ++Lampada.numEquipamento;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        String str = "";
        str += nome + "\n";
        str += "Tipo: " + this.getTipo() + "\n";
        str += "Estado: ";
        str += (this.ligado) ? "Ligado\n" : "Desligado\n";
        str += "Intensidade: " + this.intensidade + "\n";
        return str;
    }
}
