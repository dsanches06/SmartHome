/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.poo.smarthome.modulos;

/**
 *
 * @author
 */
public enum Accao {
    LIGAR, DESLIGAR, REGULAR;

    @Override
    public String toString() {
        switch (this) {
            case LIGAR:
                return "Ligar";
            case DESLIGAR:
                return "Desligar";
            case REGULAR:
                return "Regular";
        }
        return "";
    }
}
