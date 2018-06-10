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
public abstract class Modulo {

    //nome
    private String nome;

    public Modulo(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        String str = "";
        str += nome + "\n";

        return str;
    }

    public abstract ConsolaCentral getConsola();

}
