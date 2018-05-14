/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.poo.smarthome.central;

import java.util.*;
import projeto.poo.smarthome.*;
import projeto.poo.smarthome.atuadores.*;
import projeto.poo.smarthome.cliente.*;
import projeto.poo.smarthome.modulos.*;
import projeto.poo.smarthome.sensores.*;

/**
 *
 * @author
 */
public class ConsolaCentral {

    //nome da consola central
    private String nome;
    //modulo alarme
    private ModuloAlarme moduloAlarme;
    //modulo controlo de temperatura
    private ModuloControloTemperatura moduloControloTemperatura;
    //modulo controlo de luminosidade
    private ModuloControloLuminosidade moduloControloLuminosidade;
    //cliente
    private List<Cliente> clientes;
    //equipamentos conetados
    private List<Sensor> sensores;
    private List<Atuador> atuadores;
    //adicionar 

    //Constructor
    public ConsolaCentral(String nome) {
        this.nome = nome;
        this.clientes = new ArrayList<>();
        this.sensores = new ArrayList<>();
        this.atuadores = new ArrayList<>();
        this.moduloAlarme = new ModuloAlarme(this);
        this.moduloControloTemperatura = new ModuloControloTemperatura(this);
        this.moduloControloLuminosidade = new ModuloControloLuminosidade(this);
    }

    @Override
    public String toString() {
        String str = "--- Consola Central ---\n";
        str += "Nome: " + this.nome + "\n";
        for (Cliente cliente : clientes) {
            if (cliente != null) {
                str += cliente.toString();
            }
        }
        return str;
    }

    public void adicionarNovoCliente(Cliente cliente) throws ErroException {
        if (cliente != null) {
            if (!this.clientes.contains(cliente)) {
                cliente.setConsola(this);
                this.clientes.add(cliente);
            } else {
                throw new ErroException("Já existe cliente com mesmo dados.");
            }
        } else {
            throw new ErroException("Cliente não pode ser adicionado, se for nulo.");
        }
    }

    public Cliente getClientePorID(int clienteId) {
        for (Cliente cliente : this.clientes) {
            if (clienteId == cliente.getNumeroCliente()) {
                return cliente;
            }
        }
        return null;
    }

    public void conetarEquipamentos(Sensor sensor, Atuador atuador) {
        if ((sensor instanceof SensorLuminosidade)
                & (atuador instanceof Lampada)) {

        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ModuloAlarme getModuloAlarme() {
        return moduloAlarme;
    }

    public void setModuloAlarme(ModuloAlarme moduloAlarme) {
        this.moduloAlarme = moduloAlarme;
    }

    public ModuloControloTemperatura getModuloControloTemperatura() {
        return moduloControloTemperatura;
    }

    public void setModuloControloTemperatura(ModuloControloTemperatura moduloControloTemperatura) {
        this.moduloControloTemperatura = moduloControloTemperatura;
    }

    public ModuloControloLuminosidade getModuloControloLuminosidade() {
        return moduloControloLuminosidade;
    }

    public void setModuloControloLuminosidade(ModuloControloLuminosidade moduloControloLuminosidade) {
        this.moduloControloLuminosidade = moduloControloLuminosidade;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

}
