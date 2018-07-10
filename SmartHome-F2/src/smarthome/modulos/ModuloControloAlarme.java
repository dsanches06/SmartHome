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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
