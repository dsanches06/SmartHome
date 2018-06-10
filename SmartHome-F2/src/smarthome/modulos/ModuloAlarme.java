/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smarthome.modulos;

import smarthome.ErroException;
import smarthome.central.ConsolaCentral;

/**
 *
 * @author
 */
public class ModuloAlarme extends Modulo {

    private ConsolaCentral consola;

    public ModuloAlarme(ConsolaCentral consola) {
        super("Modúlo Alarme");
        this.consola = consola;
    }

    @Override
    public ConsolaCentral getConsola() {
        return consola;
    }

    

}
