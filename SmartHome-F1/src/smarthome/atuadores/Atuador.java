/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smarthome.atuadores;

import smarthome.equipamentos.TipoEquipamento;
import smarthome.equipamentos.Equipamento;

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

}
