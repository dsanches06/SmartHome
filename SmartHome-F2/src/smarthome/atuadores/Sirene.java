/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smarthome.atuadores;

import smarthome.cliente.Divisao;

/**
 *
 * @author
 */
public class Sirene extends Atuador {

    //volume minima 0
    public static final int VOLUME_MIN = 0;
    //volume maxima 10
    public static final int VOLUME_MAX = 10;
    //valor da volume
    private int volume;
    //estado ligado ou desligado
    private boolean ligado;
    //
    private static int numEquipamento = 0;
    //nome
    private String nome;
    //identificador para cada equipamento
    private int id;

    //Constructor
    public Sirene() {
        super();
        this.id = ++Sirene.numEquipamento;
        this.nome = "SR" + this.id;
        this.volume = Sirene.VOLUME_MIN;
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
        str += "Volume: " + this.volume + " ºC\n";
        return str;
    }

    public void ligar() {
        //se estiver desligado
        if (!ligado) {
            //liga a sirene
            this.ligado = true;
        }
    }

    public void desligar() {
        //se estiver ligado
        if (ligado) {
            //desliga a sirene
            this.ligado = false;
        }
    }

    public void regularEquipamento(int valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean isVolumeValido(int valor) {
        return (valor >= Sirene.VOLUME_MIN) && (valor <= Sirene.VOLUME_MAX);
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
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

    public void setId(int id) {
        this.id = id;
    }

    public Divisao getDivisao() {
        return divisao;
    }

    @Override
    public void setDivisao(Divisao divisao) {
        this.divisao = divisao;
    }

}
