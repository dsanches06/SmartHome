/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.poo.smarthome.sensores;

import projeto.poo.smarthome.cliente.Divisao;

/**
 *
 * @author
 */
public class SensorLuminosidade extends Sensor {

    private boolean ligado;
    private static int numEquipamento = 0;
    private int id;
    private String nome;

    public SensorLuminosidade() {
        super();
        this.id = ++SensorLuminosidade.numEquipamento;
        this.nome = "SL" + this.id;
        this.ligado = false;
    }

    public int medirLuzAmbiente() {
        return 0;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
