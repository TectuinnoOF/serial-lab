/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.tectuinno.seriallab.core;

/**
 * Estado inicial deseado para una línea de control del puerto serial (DTR/RTS).
 *
 * <p>Se usa al abrir el puerto para decidir si la aplicación debe modificar la línea
 * o dejarla intacta.</p>
 *
 * @author pablo-g
 * @since 0.1.0
 */
public enum LineState {

    /** No modificar el estado actual de la línea. */
    NO_CHANGE(1),

    /** Forzar la línea a estado activo (assert). */
    ON(2),

    /** Forzar la línea a estado inactivo (deassert). */
    OFF(3);

    /**
     * Código persistible del estado (por ejemplo, para guardar en el workspace).
     */
    private final int lineState;

    private LineState(int lineState) {
        this.lineState = lineState;
    }

    /**
     * Devuelve el código persistible asociado al estado.
     *
     * @return código entero del estado
     */
    public int getLineState() {
        return this.lineState;
    }
}
