/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smarthome.modulos;

/**
 *
 * @author
 */
public enum Modo {
    AUTOMATICO, MANUAL;

    @Override
    public String toString() {
        switch (this) {
            case AUTOMATICO:
                return "Automático";
            case MANUAL:
                return "Manual";
        }
        return "";
    }
}
