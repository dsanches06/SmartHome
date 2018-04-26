/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.poo.smarthome.cliente;

import java.util.*;
import projeto.poo.smarthome.equipamentos.Equipamento;

/**
 *
 * @author
 */
public class Divisao {

    private static int numDivisao = 0;
    //identificador para cada equipamento
    private int id;
    //nome
    private String nomeDivisao;
    //diversos equipamentos
    private List<Equipamento> equipamentos;
    //temperatura
    private int temperatura;

    //Constructor
    public Divisao() {
        this.id = gerarID();
        this.nomeDivisao = "D" + this.id;
        this.equipamentos = new ArrayList<>();
        this.temperatura = 0;
    }

    public void adicionarEquipamento(Equipamento equipamento) {
        if (equipamento != null) {
            if (!equipamentos.contains(equipamento)) {
                equipamento.setDivisao(this);
                this.equipamentos.add(equipamento);
            }
        }
    }

    public String getNomeDivisao() {
        return nomeDivisao;
    }

    public void setNomeDivisao(String nomeDivisao) {
        this.nomeDivisao = nomeDivisao;
    }

    public List<Equipamento> getEquipamentos() {
        return equipamentos;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    private int gerarID() {
        return ++Divisao.numDivisao;
    }

    public int getId() {
        return id;
    }

}
