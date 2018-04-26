/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.poo.smarthome.atuadores;

import projeto.poo.smarthome.cliente.Divisao;
import projeto.poo.smarthome.equipamentos.TipoEquipamento;

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
    public Sirene(TipoEquipamento tipo, int volume) {
        super(tipo);
        this.id = gerarID();
        this.nome = "Sirene" + this.id;
        if (isVolumeValido(volume)) {
            this.volume = volume;
        } else {
            this.volume = Sirene.VOLUME_MIN;
        }
    }

    @Override
    public void ligar() {
        //se estiver desligado
        if (!ligado) {
            //liga a sirene
            this.ligado = true;
        }
    }

    @Override
    public void desligar() {
        //se estiver ligado
        if (ligado) {
            //desliga a sirene
            this.ligado = false;
        }
    }

    private boolean isVolumeValido(int valor) {
        return (valor >= Sirene.VOLUME_MIN) && (valor <= Sirene.VOLUME_MAX);
    }

    @Override
    public void setDivisao(Divisao divisao) {
        this.divisao = divisao;
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

    private int gerarID() {
        return ++Sirene.numEquipamento;
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
        str += "Volume: " + this.volume + "\n";
        return str;
    }
}
