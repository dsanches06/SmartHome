/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.poo.smarthome.modulos;

import java.util.List;
import projeto.poo.smarthome.cliente.Divisao;
import projeto.poo.smarthome.equipamentos.Equipamento;

/**
 *
 * @author
 */
public class ModuloControloTemperatura extends Modulo {

    @Override
    public void adicionarDivisao(Divisao divisao) {
       super.adicionarDivisao(divisao);
    }

    @Override
    public void adicionarEquipamentoNaDivisao(int divisaoId, Equipamento equipamento) {
     super.adicionarEquipamentoNaDivisao(divisaoId, equipamento);
    }

    @Override
    public List<Divisao> getDivisoes() {
        return super.getDivisoes();
    }

    @Override
    public List<Equipamento> getEquipamentos() {
        return super.getEquipamentos();
    }

    @Override
    public void associarEquipamento() {
    
    }

}
