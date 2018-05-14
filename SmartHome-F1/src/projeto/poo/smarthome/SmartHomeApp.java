/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.poo.smarthome;

import projeto.poo.smarthome.atuadores.*;
import projeto.poo.smarthome.atuadores.*;
import projeto.poo.smarthome.central.ConsolaCentral;
import projeto.poo.smarthome.cliente.Cliente;
import projeto.poo.smarthome.cliente.Divisao;
import projeto.poo.smarthome.equipamentos.*;
import projeto.poo.smarthome.modulos.Accao;
import projeto.poo.smarthome.modulos.Modo;

/**
 *
 * @author
 */
public class SmartHomeApp {

    /**
     * @param args the command line arguments
     * @throws projeto.poo.smarthome.ErroException
     */
    public static void main(String[] args) throws ErroException {
        // TODO code application logic here
        //cliente
        Cliente cliente = new Cliente("Edson Cazanga", "Barreiro");
        //3 divisao
        Divisao cozinha = new Divisao("Cozinha");
        Divisao sala = new Divisao("Sala");

        //3 lampada para cada divisao
        Lampada lampada1 = new Lampada();
        ArCondicionado ac1 = new ArCondicionado();

        //adicionar equipamento nas divisoes
        cozinha.adicionarEquipamento(lampada1);
        sala.adicionarEquipamento(ac1);

        //adicionar divisao na habitação do cliente
        cliente.getHabitacao().adicionarDivisao(cozinha);
        cliente.getHabitacao().adicionarDivisao(sala);

        //consola
        ConsolaCentral consola = new ConsolaCentral("Securitas AB");

        //adicionar cliente na consola
        consola.adicionarNovoCliente(cliente);

        consola.getModuloControloLuminosidade().ligarEquipamento(1, 1, 1);
        consola.getModuloControloLuminosidade().ligarEquipamento(1, 2, 1);

        //mostrar clientes na consola
        System.out.println(consola.toString());

    }

}
