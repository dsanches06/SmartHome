/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.poo.smarthome.atuadores;

import projeto.poo.smarthome.ErroException;
import projeto.poo.smarthome.cliente.Divisao;
import projeto.poo.smarthome.equipamentos.TipoEquipamento;
import projeto.poo.smarthome.modulos.Accao;
import projeto.poo.smarthome.modulos.Modo;

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
    public Sirene(int volume) {
        super();
        this.id = ++Sirene.numEquipamento;
        this.nome = "Sirene" + this.id;
        if (isVolumeValido(volume)) {
            this.volume = volume;
        } else {
            this.volume = Sirene.VOLUME_MIN;
        }
    }

    public void ligar(Modo modo) {
        //se estiver desligado
        if (!ligado) {
            //liga a sirene
            this.ligado = true;
        }
    }

    public void desligar(Modo modo) {
        //se estiver ligado
        if (ligado) {
            //desliga a sirene
            this.ligado = false;
        }
    }

    public void regularEquipamento(Modo modo, int valor) {
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
