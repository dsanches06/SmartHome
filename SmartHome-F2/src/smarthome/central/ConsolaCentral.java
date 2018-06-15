/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smarthome.central;

import java.util.ArrayList;
import java.util.List;
import smarthome.atuadores.Atuador;
import smarthome.atuadores.Lampada;
import smarthome.cliente.Cliente;
import smarthome.modulos.ModuloAlarme;
import smarthome.modulos.ModuloControloLuminosidade;
import smarthome.modulos.ModuloControloTemperatura;
import smarthome.sensores.Sensor;
import smarthome.sensores.SensorLuminosidade;

/**
 *
 * @author
 */
public class ConsolaCentral {

    //modulo alarme
    private ModuloAlarme moduloAlarme;
    //modulo controlo de temperatura
    private ModuloControloTemperatura moduloControloTemperatura;
    //modulo controlo de luminosidade
    private ModuloControloLuminosidade moduloControloLuminosidade;
    //cliente
    private List<Cliente> clientes;
    //adicionar 

    //Constructor
    public ConsolaCentral() {
        this.clientes = new ArrayList<>();
        this.moduloAlarme = new ModuloAlarme(this);
        this.moduloControloTemperatura = new ModuloControloTemperatura(this);
        this.moduloControloLuminosidade = new ModuloControloLuminosidade(this);
    }

    @Override
    public String toString() {
        String str = "--- Consola Central ---\n";
        for (Cliente cliente : clientes) {
            if (cliente != null) {
                str += cliente.toString();
            }
        }
        return str;
    }

    public boolean adicionarNovoCliente(Cliente cliente) {
        if (cliente != null) {
            if (!this.clientes.contains(cliente)) {
                cliente.setConsola(this);
                this.clientes.add(cliente);
                return true;
            }
        }
        return false;
    }

    public boolean removerCliente(Cliente cliente) {
        if (cliente != null) {
            if (this.clientes.contains(cliente)) {
                this.clientes.remove(cliente);
                return true;
            }
        }
        return false;
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

    public List<String> obterLocalidade() {
        List<String> lista = new ArrayList<>();
        lista.add("Almada");
        lista.add("Aveiro");
        lista.add("Barreiro");
        lista.add("Coimbra");
        lista.add("Faro");
        lista.add("Lisboa");
        lista.add("Montijo");
        lista.add("Porto");
        lista.add("Seixal");
        lista.add("Setúbal");
        return lista;
    }

    public List<String> obterGenero() {
        List<String> lista = new ArrayList<>();
        lista.add("F");
        lista.add("M");
        return lista;
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
