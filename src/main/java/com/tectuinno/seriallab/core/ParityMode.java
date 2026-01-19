/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.tectuinno.seriallab.core;

/**
 * Modos de paridad para la configuración UART.
 *
 * <ul>
 * <li>{@link #NONE}: sin bit de paridad.</li>
 * <li>{@link #EVEN}: paridad par.</li>
 * <li>{@link #ODD}: paridad impar.</li>
 * </ul>
 *
 * @author root
 * @since 0.1.0
 */
public enum ParityMode {

    /**
     * Sin paridad.
     */
    NONE(1),
    /**
     * Paridad par.
     */
    EVEN(2),
    /**
     * Paridad impar.
     */
    ODD(3);

    /**
     * Código persistible del modo (por ejemplo, para guardar en el workspace).
     */
    private final int parityMode;

    private ParityMode(int parityMode) {
        this.parityMode = parityMode;
    }

    /**
     * Devuelve el código persistible asociado al modo.
     *
     * @return código entero del modo
     */
    public int getParityMode() {
        return this.parityMode;
    }
}
