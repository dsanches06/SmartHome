/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smarthome.atuadores;

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
