/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smarthome.sensores;

import smarthome.cliente.Divisao;

/**
 *
 * @author
 */
public class SensorPortaAberta extends Sensor {

    private boolean ligado;
    private boolean portaAberta;
    private static int numEquipamento = 0;
    private int id;
    private String nome;

    public SensorPortaAberta() {
        super();
        this.id = ++SensorPortaAberta.numEquipamento;
        this.nome = "SPA" + this.id;
        this.ligado = false;
        this.portaAberta = false;
    }

    @Override
    public String toString() {
        String str = "";
        str += "Equipamento: " + nome + "\n";
        str += "Tipo: " + this.getTipo() + "\n";
        str += "Estado: ";
        str += (this.ligado) ? "Ligado\n" : "Desligado\n";
        str += "Porta Aberta: ";
        str += (this.portaAberta) ? "Sim\n" : "N/A\n";
        return str;
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

    public boolean isPortaAberta() {
        return portaAberta;
    }

    public void setPortaAberta(boolean portaAberta) {
        this.portaAberta = portaAberta;
    }

}
