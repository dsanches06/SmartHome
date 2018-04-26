/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.poo.smarthome.cliente;

/**
 *
 * @author
 */
public class Cliente {

    //nome
    private String nomeCliente;
    //morada
    private String morada;
    //numero e cliente atribuido na consola central
    private int numeroCliente;
    //Habitaçao
    private Habitacao habitacao;

    //Constructor
    public Cliente(String nomeCliente, String morada, int numeroCliente) {
        this.nomeCliente = nomeCliente;
        this.morada = morada;
        this.numeroCliente = numeroCliente;
        this.habitacao = new Habitacao();
    }

}
