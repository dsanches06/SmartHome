/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.poo.smarthome.modulos;

import projeto.poo.smarthome.ErroException;
import projeto.poo.smarthome.central.ConsolaCentral;

/**
 *
 * @author
 */
public class ModuloControloTemperatura extends Modulo {

    private ConsolaCentral consola;

    public ModuloControloTemperatura(ConsolaCentral consola) {
        super("Modúlo Temperatura");
        this.consola = consola;
    }

    
    @Override
    public ConsolaCentral getConsola() {
       return consola;
    }

}
