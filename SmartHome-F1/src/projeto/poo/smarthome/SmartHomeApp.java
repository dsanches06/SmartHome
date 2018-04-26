/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.poo.smarthome;

import projeto.poo.smarthome.atuadores.*;
import projeto.poo.smarthome.atuadores.*;
import projeto.poo.smarthome.equipamentos.*;

/**
 *
 * @author
 */
public class SmartHomeApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Lampada lampada1 = new Lampada(TipoEquipamento.ATUADOR, 20);
        lampada1.ligar();
        System.out.println(lampada1);

        Lampada lampada2 = new Lampada(TipoEquipamento.ATUADOR, 30);
        lampada2.setIntensidade(15);
        lampada2.ligar();
        System.out.println(lampada2);

        ArCondicionado ac1 = new ArCondicionado(TipoEquipamento.ATUADOR, 20);
        ac1.ligar();
        System.out.println(ac1);

        Sirene s1 = new Sirene(TipoEquipamento.ATUADOR, 10);
        s1.ligar();
        System.out.println(s1);

    }

}
