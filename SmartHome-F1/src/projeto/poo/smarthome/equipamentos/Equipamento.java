/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.poo.smarthome.equipamentos;

import projeto.poo.smarthome.cliente.*;

/**
 *
 * @author
 */
public abstract class Equipamento {

    // tipo de equipamento
    private TipoEquipamento tipo;
    //divisão onde se encontra o equipamento
    protected Divisao divisao;

    //Constructor
    public Equipamento(TipoEquipamento tipo) {
        this.tipo = tipo;
        this.divisao = null;
    }

    public abstract int getId();

    public TipoEquipamento getTipo() {
        return tipo;
    }

    public abstract void setDivisao(Divisao divisao);

}
