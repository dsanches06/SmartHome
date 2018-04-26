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
    public ArCondicionado(TipoEquipamento tipo, int temperatura) {
        super(tipo);
        this.id = gerarID();
        this.nome = "AC" + this.id;
        if (isTemperaturaValido(temperatura)) {
            this.temperatura = temperatura;
        } else {
            this.temperatura = ArCondicionado.TEMPERATURA_MIN;
        }
        this.ligado = false;
    }

    @Override
    public void ligar() {
        //se estiver desligado
        if (!ligado) {
            //liga o AC
            this.ligado = true;
        }
    }

    @Override
    public void desligar() {
        //se estiver ligado
        if (ligado) {
            //desliga o AC
            this.ligado = false;
        }
    }

    private boolean isTemperaturaValido(int valor) {
        return (valor >= ArCondicionado.TEMPERATURA_MIN) && (valor <= ArCondicionado.TEMPERATURA_MAX);
    }

    @Override
    public void setDivisao(Divisao divisao) {
        this.divisao = divisao;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    private int gerarID() {
        return ++ArCondicionado.numEquipamento;
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
        str += "Temperatura: " + this.temperatura + "ºC\n";
        return str;
    }
}
