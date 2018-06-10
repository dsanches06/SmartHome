/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smarthome.modulos;

import smarthome.ErroException;
import smarthome.central.ConsolaCentral;
import smarthome.cliente.Cliente;
import smarthome.cliente.Divisao;


/**
 *
 * @author
 */
public class ModuloControloLuminosidade extends Modulo {

    private ConsolaCentral consola;

    public ModuloControloLuminosidade(ConsolaCentral consola) {
        super("Modúlo Luminosidade");
        this.consola = consola;
    }

    public void ligarEquipamento(int clienteId, int divisaoId, int equipamentoId) throws ErroException {
        Cliente cliente = this.consola.getClientePorID(clienteId);
        if (cliente != null) {
            Divisao divisao = cliente.getHabitacao().getDivisaoPorID(divisaoId);
            if (divisao != null) {
                divisao.ligarEquipamento(equipamentoId);
            } else {
                throw new ErroException("Não existe nenhuma divisão com este ID.");
            }
        } else {
            throw new ErroException("Não existe nenhum cliente com este ID.");
        }
    }

    public void desligarEquipamento(int clienteId, int divisaoId, int equipamentoId) throws ErroException {
        Cliente cliente = this.consola.getClientePorID(clienteId);
        if (cliente != null) {
            Divisao divisao = cliente.getHabitacao().getDivisaoPorID(divisaoId);
            if (divisao != null) {
                divisao.desligarEquipamento(equipamentoId);
            } else {
                throw new ErroException("Não existe nenhuma divisão com este ID.");
            }
        } else {
            throw new ErroException("Não existe nenhum cliente com este ID.");
        }
    }
    
    
    public void regularEquipamento(int clienteId, int divisaoId, int equipamentoId,int valor) throws ErroException {
        Cliente cliente = this.consola.getClientePorID(clienteId);
        if (cliente != null) {
            Divisao divisao = cliente.getHabitacao().getDivisaoPorID(divisaoId);
            if (divisao != null) {
                divisao.desligarEquipamento(equipamentoId);
            } else {
                throw new ErroException("Não existe nenhuma divisão com este ID.");
            }
        } else {
            throw new ErroException("Não existe nenhum cliente com este ID.");
        }
    }

    @Override
    public ConsolaCentral getConsola() {
        return consola;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
