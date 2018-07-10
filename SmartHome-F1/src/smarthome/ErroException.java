/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smarthome;

/**
 *
 * @author
 */
public class ErroException extends Exception {

    /**
     * Creates a new instance of <code>ErroException</code> without detail
     * message.
     */
    public ErroException() {
    }

    /**
     * Constructs an instance of <code>ErroException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public ErroException(String msg) {
        super(msg);
    }
}
