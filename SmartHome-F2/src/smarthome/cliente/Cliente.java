/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smarthome.cliente;

import smarthome.central.ConsolaCentral;

/**
 *
 * @author
 */
public class Cliente {

    private static int numCliente = 0;
    //nome
    private String nomeCliente;
    //genero
    private char genero;
    //morada
    private String morada;
    //
    private int numeroCliente;
    //Habitaçao
    private Habitacao habitacao;
    //consola
    private ConsolaCentral consola;

    //Constructor
    public Cliente(String nomeCliente, String morada, char genero) {
        this.nomeCliente = nomeCliente;
        this.genero = genero;
        this.morada = morada;
        this.numeroCliente = ++Cliente.numCliente;
        this.habitacao = new Habitacao();
        this.consola = null;
    }

    @Override
    public String toString() {
        String str = "--- Cliente " + this.numeroCliente + " ---\n";
        str += "Nome: " + this.nomeCliente + "\n";
        str += "Sexo: " + this.genero + "\n";
        str += "Morada: " + this.morada + "\n";
        str += "--- Habitação ---\n" + this.habitacao;
        return str;
    }

    public String mostrarInfDashBoard() {
        StringBuilder str = new StringBuilder();
        str.append(this.nomeCliente)
                .append("\n\nNúmero: ")
                .append(this.numeroCliente)
                .append("\n\nSexo: ")
                .append(this.genero)
                .append("\nMorada: ")
                .append(this.morada);
        return str.toString();
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public int getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(int numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public Habitacao getHabitacao() {
        return habitacao;
    }

    public void setHabitacao(Habitacao habitacao) {
        this.habitacao = habitacao;
    }

    public ConsolaCentral getConsola() {
        return consola;
    }

    public void setConsola(ConsolaCentral consola) {
        this.consola = consola;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

}
