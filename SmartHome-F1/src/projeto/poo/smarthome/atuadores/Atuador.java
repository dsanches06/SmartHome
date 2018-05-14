/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.poo.smarthome.atuadores;

import projeto.poo.smarthome.ErroException;
import projeto.poo.smarthome.cliente.Divisao;
import projeto.poo.smarthome.equipamentos.*;
import projeto.poo.smarthome.equipamentos.*;
import projeto.poo.smarthome.modulos.Accao;
import projeto.poo.smarthome.modulos.Modo;

/**
 *
 * @author
 */
public abstract class Atuador extends Equipamento {

    private boolean modoAutomatico;

    //Constructor
    public Atuador() {
        super(TipoEquipamento.ATUADOR);
        this.modoAutomatico = false;
    }

    @Override
    public TipoEquipamento getTipo() {
        return super.getTipo();
    }

    public boolean isModoAutomatico() {
        return modoAutomatico;
    }

    public void setModoAutomatico(boolean modoAutomatico) {
        this.modoAutomatico = modoAutomatico;
    }

    @Override
    public abstract int getId();

}
