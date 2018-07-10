/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smarthome.equipamentos;

/**
 *
 * @author 
 */
public enum TipoEquipamento {
    ATUADOR, SENSOR;

    @Override
    public String toString() {
        switch (this) {
            case ATUADOR:
                return "Atuador";
            case SENSOR:
                return "Sensor";
        }
        return "";
    }
}
