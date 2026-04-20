/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.tectuinno.seriallab.core;

/**
 * Modos de timeout para operaciones de lectura/escritura en el puerto serial.
 *
 * <p>Definen si las operaciones bloquean, y bajo qué condiciones se aplica el tiempo de espera
 * configurado (readTimeoutMs/writeTimeoutMs) en la capa de infraestructura.</p>
 *
 * @author pablo-g
 * @since 0.1.0
 */
public enum TimeOutMode {

    /** Sin timeouts (comportamiento por defecto de la librería/driver). */
    DISABLED(1),

    /** Lectura no bloqueante: retorna de inmediato con lo disponible. */
    NON_BLOCKING(2),

    /** Lectura semi-bloqueante: espera por datos hasta el timeout configurado. */
    READ_SEMI_BLOCKING(3),

    /** Lectura bloqueante: espera hasta recibir datos o hasta que venza el timeout. */
    READ_BLOCKING(4);

    /**
     * Código persistible del modo (por ejemplo, para guardar en el workspace).
     */
    private final int timeOutMode;

    private TimeOutMode(int timeOutMode) {
        this.timeOutMode = timeOutMode;
    }

    /**
     * Devuelve el código persistible asociado al modo.
     *
     * @return código entero del modo
     */
    public int getTimeOutMode() {
        return this.timeOutMode;
    }
}
