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
    private String nome;
    //genero
    private String genero;
    //morada
    private String localidade;
    //
    private int numeroCliente;
    //Habitaçao
    private Habitacao habitacao;
    //consola
    private ConsolaCentral consola;

    //Constructor
    public Cliente(String nome, String apelido, String morada, String genero) {
        this.nome = getNomeCompleto(nome, apelido);
        this.genero = genero;
        this.localidade = morada;
        this.numeroCliente = ++Cliente.numCliente;
        this.habitacao = new Habitacao();
        this.consola = null;
    }

    @Override
    public String toString() {
        String str = "--- Cliente " + this.numeroCliente + " ---\n";
        str += "Nome: " + this.nome + "\n";
        str += "Sexo: " + this.genero + "\n";
        str += "Morada: " + this.localidade + "\n";
        str += "--- Habitação ---\n" + this.habitacao;
        return str;
    }

    public String mostrarInfDashBoard() {
        StringBuilder str = new StringBuilder();
        str.append(this.nome)
                .append("\n\nNúmero: ")
                .append(this.numeroCliente)
                .append("\nSexo: ")
                .append(this.genero)
                .append("\nMorada: ")
                .append(this.localidade)
                .append("\nTotal Divisões: ")
                .append(this.habitacao.getDivisoes().size());
        return str.toString();
    }

    private String getNomeCompleto(String nomeCliente, String apelidoCliente) {
        return nomeCliente + " " + apelidoCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
