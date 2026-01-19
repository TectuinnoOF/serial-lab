/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.tectuinno.seriallab.core;

/**
 * Modos de control de flujo para comunicación serial.
 *
 * <p>El control de flujo permite pausar/reanudar la transmisión para evitar pérdida de datos
 * cuando el receptor no puede consumir bytes al ritmo del emisor.</p>
 *
 * <ul>
 *   <li>{@link #NONE}: sin control de flujo.</li>
 *   <li>{@link #RTS_CTS}: control de flujo por hardware usando líneas RTS/CTS.</li>
 *   <li>{@link #XON_XOFF}: control de flujo por software usando bytes XON/XOFF.</li>
 * </ul>
 *
 * @author root
 * @since 0.1.0
 */
public enum FlowControlMode {
    
    /** No se aplica control de flujo. */
    NONE(1),

    /** Control de flujo por hardware (RTS/CTS). */
    RTS_CTS(2),

    /** Control de flujo por software (XON/XOFF). */
    XON_XOFF(3);
    
    /**
     * Código persistible del modo (por ejemplo, para guardar en el workspace).
     */
    private int controlMode;
    
    /**
     * Constructor privado, previene instancia
     * @param controlMode 
     */
    private FlowControlMode(int controlMode){
        this.controlMode = controlMode;
    }
    
    /**
     * Devuelve el código persistible asociado al modo.
     *
     * @return código entero del modo
     */
    public int getControlMode(){
        return this.controlMode;
    }
    
}
