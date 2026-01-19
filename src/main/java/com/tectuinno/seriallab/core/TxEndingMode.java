/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.tectuinno.seriallab.core;

/**
 * Modos de terminación de línea que se pueden anexar automáticamente al final de un envío (TX).
 *
 * <p>Útil cuando el dispositivo remoto interpreta comandos por fin de línea.</p>
 *
 * @author root
 * @since 0.1.0
 */
public enum TxEndingMode {
    
    /** No agrega terminador. */
    NONE(1),

    /** Agrega {@code \r} (CR, 0x0D). */
    CR(2),

    /** Agrega {@code \n} (LF, 0x0A). */
    LF(3),

    /** Agrega {@code \r\n} (CRLF, 0x0D 0x0A). */
    CRLF(4);
    
    /**
     * Código persistible del modo (por ejemplo, para guardar en el workspace).
     */
    private int endingMode;
    
    
    private TxEndingMode(int endingMode){
        this.endingMode = endingMode;
    }
    
    /**
     * Devuelve el código persistible asociado al modo.
     *
     * @return código entero del modo
     */
    public int getEndingMode(){
        return this.endingMode;
    }
    
}
