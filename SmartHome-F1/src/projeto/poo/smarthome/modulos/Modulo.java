/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.poo.smarthome.modulos;

import java.util.*;
import projeto.poo.smarthome.cliente.*;
import projeto.poo.smarthome.equipamentos.*;

/**
 *
 * @author
 */
public abstract class Modulo {

    //divisoes
    private List<Divisao> divisoes;
    //diversos equipamentos
    private List<Equipamento> equipamentos;

    public Modulo() {
        this.divisoes = new ArrayList<>();
        this.equipamentos = new ArrayList<>();
    }

    public void adicionarDivisao(Divisao divisao) {
        if (divisao != null) {
            if (!divisoes.contains(divisao)) {
                this.divisoes.add(divisao);
            }
        }
    }

    public void adicionarEquipamentoNaDivisao(int divisaoId, Equipamento equipamento) {
        for (Divisao divisao : this.divisoes) {
            if (divisaoId == divisao.getId()) {
                if (!divisao.getEquipamentos().contains(equipamento)) {
                    divisao.adicionarEquipamento(equipamento);
                    this.equipamentos.add(equipamento);
                }
            }
        }
    }

    public List<Divisao> getDivisoes() {
        return divisoes;
    }

    public List<Equipamento> getEquipamentos() {
        return equipamentos;
    }

    public abstract void associarEquipamento();
}
