/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.poo.smarthome.atuadores;

import projeto.poo.smarthome.cliente.Divisao;
import projeto.poo.smarthome.equipamentos.*;
import projeto.poo.smarthome.equipamentos.*;

/**
 *
 * @author
 */
public abstract class Atuador extends Equipamento {

    //Constructor
    public Atuador(TipoEquipamento tipo) {
        super(tipo);
    }

    @Override
    public TipoEquipamento getTipo() {
        return super.getTipo();
    }

    public abstract void ligar();

    public abstract void desligar();

}
