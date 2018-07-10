/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smarthome.cliente;

import java.io.*;
import smarthome.central.*;

/**
 *
 * @author
 */
public class Cliente implements Serializable {

    private static int numCliente = 0;
    private int numeroCliente;
    private String nome;
    private String localidade;
    private String genero;
    private int numeroDivisao;
    private Habitacao habitacao;
    private ConsolaCentral consola;

    //Constructor
    public Cliente(String nome, String localidade, String genero, int numeroDivisao, ConsolaCentral consola) {
        this.numeroCliente = ++Cliente.numCliente;
        this.nome = nome;
        this.localidade = localidade;
        this.genero = genero;
        this.numeroDivisao = numeroDivisao;
        this.habitacao = new Habitacao(consola, numeroDivisao);
        this.consola = consola;
    }

    @Override
    public String toString() {
        String str = "--- Cliente " + this.numeroCliente + " ---\n";
        str += "Nome: " + this.nome + "\n";
        str += "Sexo: " + this.genero + "\n";
        str += "Morada: " + this.localidade + "\n";
        str += "Numero Divisão: " + this.numeroDivisao + "\n";
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
                .append(this.numeroDivisao);
        return str.toString();
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

    public int getNumeroDivisao() {
        return numeroDivisao;
    }

    public void setNumeroDivisao(int numeroDivisao) {
        this.numeroDivisao = numeroDivisao;
    }
}
