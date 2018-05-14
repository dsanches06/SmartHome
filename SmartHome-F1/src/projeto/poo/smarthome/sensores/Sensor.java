/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.poo.smarthome.sensores;

import projeto.poo.smarthome.cliente.Divisao;
import projeto.poo.smarthome.equipamentos.Equipamento;
import projeto.poo.smarthome.equipamentos.TipoEquipamento;

/**
 *
 * @author
 */
public abstract class Sensor extends Equipamento {

    //Constructor
    public Sensor() {
        super(TipoEquipamento.SENSOR);
    }

    @Override
    public TipoEquipamento getTipo() {
        return super.getTipo();
    }



}
