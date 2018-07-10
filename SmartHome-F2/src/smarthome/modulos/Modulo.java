/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smarthome.modulos;

import smarthome.ErroException;
import smarthome.central.ConsolaCentral;
import smarthome.cliente.Cliente;

/**
 *
 * @author
 */
public abstract class Modulo {

    //consola
    private ConsolaCentral consola;

    public Modulo(ConsolaCentral consola) {
        this.consola = consola;
    }

    //public abstract void controlarEquipamento(Cliente cliente, int divisaoId) throws ErroException;

    public abstract String getNome();

    public ConsolaCentral getConsola() {
        return consola;
    }

}
