/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smarthome.modulos;

import smarthome.*;
import smarthome.central.*;
import smarthome.cliente.*;

/**
 *
 * @author
 */
public class ModuloControloAlarme extends Modulo {

    private String nome;

    public ModuloControloAlarme(ConsolaCentral consola, String nome) {
        super(consola);
        this.nome = nome;
    }

    @Override
    public ConsolaCentral getConsola() {
        return super.getConsola();
    }

    @Override
    public String getNome() {
        return nome;
    }

    // @Override
    public void controlarEquipamento(Cliente cliente, int divisaoId) throws ErroException {

    }

}
