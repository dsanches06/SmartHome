/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.poo.smarthome.central;

import java.util.ArrayList;
import java.util.List;
import projeto.poo.smarthome.cliente.Cliente;
import projeto.poo.smarthome.equipamentos.Equipamento;
import projeto.poo.smarthome.modulos.*;

/**
 *
 * @author
 */
public class ConsolaCentral {

    //nome da consola central
    private String nomeConsola;
    //modulo alarme
    private Modulo moduloAlarme;
    //modulo controlo de temperatura
    private Modulo moduloControloTemperatura;
    //modulo controlo de luminosidade
    private Modulo moduloControloLuminosidade;
    //cliente
    private List<Cliente> clientes;

    //Constructor
    public ConsolaCentral(String nomeConsola) {
        this.nomeConsola = nomeConsola;
        this.clientes = new ArrayList<>();
        this.moduloAlarme = new ModuloAlarme();
        this.moduloControloTemperatura = new ModuloControloTemperatura();
        this.moduloControloLuminosidade = new ModuloControloLuminosidade();
    }
}
