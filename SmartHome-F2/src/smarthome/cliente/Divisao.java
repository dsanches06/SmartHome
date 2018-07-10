/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smarthome.cliente;

import java.util.*;
import smarthome.ErroException;
import smarthome.atuadores.ArCondicionado;
import smarthome.atuadores.Lampada;
import smarthome.central.ConsolaCentral;
import smarthome.equipamentos.Equipamento;
import smarthome.modulos.Modulo;

/**
 *
 * @author
 */
public class Divisao {

    private static int numDivisao = 0;
    //identificador para cada equipamento
    private int divisaoID;
    //diversos equipamentos
    private List<Equipamento> equipamentos;
    //temperatura
    private int temperatura;
    private ConsolaCentral consola;

    //Constructor
    public Divisao(ConsolaCentral consola) {
        this.divisaoID = ++Divisao.numDivisao;
        this.equipamentos = new ArrayList<>();
        this.consola = consola;
    }

    public void adicionarEquipamento(Equipamento equipamento) {
        if (equipamento != null) {
            if (!this.equipamentos.contains(equipamento)) {
                equipamento.setDivisao(this);
                this.equipamentos.add(equipamento);
            }
        }
    }

    public Equipamento getEquipamentoNaDivisaoPorID(int equipamentoId) {
        for (Equipamento equipamento : this.equipamentos) {
            if (equipamentoId == equipamento.getId()) {
                return equipamento;
            }
        }
        return null;
    }

    public Equipamento getEquipamentoPorIndex(int index) {
        return this.equipamentos.get(index);
    }

    public void ligarEquipamento(int equipamentoId) throws ErroException {
        Equipamento equipamento = this.getEquipamentoNaDivisaoPorID(equipamentoId);
        if (equipamento != null) {
            if (equipamento instanceof Lampada) {
                ((Lampada) equipamento).ligar();
            } else if (equipamento instanceof ArCondicionado) {
                ((ArCondicionado) equipamento).ligar();
            } else {
                throw new ErroException("Este equipamento não é do tipo Atuador.");
            }
        } else {
            throw new ErroException("Não existe nenhum equipamento com este ID.");
        }
    }

    public void desligarEquipamento(int equipamentoId) throws ErroException {
        Equipamento equipamento = this.getEquipamentoNaDivisaoPorID(equipamentoId);
        if (equipamento != null) {
            if (equipamento instanceof Lampada) {
                ((Lampada) equipamento).desligar();
            } else if (equipamento instanceof ArCondicionado) {
                ((ArCondicionado) equipamento).desligar();
            } else {
                throw new ErroException("Este equipamento não é do tipo Atuador.");
            }
        } else {
            throw new ErroException("Não existe nenhum equipamento com este ID.");
        }
    }

    public void regularEquipamento(int equipamentoId, int valor) throws ErroException {
        Equipamento equipamento = this.getEquipamentoNaDivisaoPorID(equipamentoId);
        if (equipamento != null) {
            if (equipamento instanceof Lampada) {
                ((Lampada) equipamento).regularEquipamento(valor);
            } else if (equipamento instanceof ArCondicionado) {
                ((ArCondicionado) equipamento).regularEquipamento(valor);
            } else {
                throw new ErroException("Este equipamento não é do tipo Atuador.");
            }
        } else {
            throw new ErroException("Não existe nenhum equipamento com este ID.");
        }
    }

    @Override
    public String toString() {
        String str = "--- Divisão ---\n";
        str += "ID: " + this.divisaoID + "\n";
        str += "Qt Equipamento: " + this.equipamentos.size() + "\n";
        for (Equipamento equipamento : equipamentos) {
            if (equipamento != null) {
                str += "\n" + equipamento.toString() + "\n";
            }
        }
        return str;
    }

    public String mostrarInfDashBoard() {
        StringBuilder str = new StringBuilder();
        str.append("\nDivisão: ")
                .append(this.divisaoID)
                .append("\nQt Equipamento: ")
                .append(this.equipamentos.size());
        return str.toString();
    }

    public int getDivisaoID() {
        return divisaoID;
    }

    public void setDivisaoID(int divisaoID) {
        this.divisaoID = divisaoID;
    }

    public List<Equipamento> getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(List<Equipamento> equipamentos) {
        this.equipamentos = equipamentos;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

}
