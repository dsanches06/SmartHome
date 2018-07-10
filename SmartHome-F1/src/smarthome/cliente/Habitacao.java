/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smarthome.cliente;

import java.util.*;
import smarthome.central.*;
import smarthome.equipamentos.*;

/**
 *
 * @author
 */
public class Habitacao {

    //uma lista de divisoes
    private List<Divisao> divisoes;
    private ConsolaCentral consola;

    //Constructor
    public Habitacao(ConsolaCentral consola, int numeroDivisao) {
        this.divisoes = new ArrayList<>(numeroDivisao);
        this.consola = consola;
        for (int i = 0; i < numeroDivisao; i++) {
            this.divisoes.add(new Divisao(consola));
        }
    }

    public Divisao getDivisaoPorID(int divisaoId) {
        for (Divisao divisao : divisoes) {
            if (divisaoId == divisao.getDivisaoID()) {
                return divisao;
            }
        }
        return null;
    }

    public Divisao getDivisaoPorIndex(int index) {
        return this.divisoes.get(index);
    }

    public Divisao teste() {
        Divisao aux = new Divisao(consola);
        for (Divisao divisao : divisoes) {
            if (divisao != null) {
                for (Equipamento equipamento : divisao.getEquipamentos()) {
                    if (equipamento != null) {
                        aux.adicionarEquipamento(equipamento);
                    }
                }
            }
        }
        return aux;
    }

    @Override
    public String toString() {
        String str = "";
        for (Divisao divisao : divisoes) {
            if (divisao != null) {
                str += divisao.toString();
            }
        }
        return str;
    }

    public List<Divisao> getDivisoes() {
        return divisoes;
    }

    public void setDivisoes(List<Divisao> divisoes) {
        this.divisoes = divisoes;
    }

}
