/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.tectuinno.seriallab.core;

/**
 * Estrategias de framing para separar el flujo de bytes RX en mensajes.
 *
 * <ul>
 *   <li>{@link #RAW}: no se segmenta; se trata como stream continuo.</li>
 *   <li>{@link #NEWLINE_LF}: un mensaje termina con {@code \n} (LF, 0x0A).</li>
 *   <li>{@link #NEWLINE_CRLF}: un mensaje termina con {@code \r\n} (CRLF, 0x0D 0x0A).</li>
 * </ul>
 *
 * @author root
 * @since 0.1.0
 */
public enum FramingMode {
    
    
    /** Stream sin segmentación. */
    RAW(1),

    /** Segmentación por fin de línea LF. */
    NEWLINE_LF(2),

    /** Segmentación por fin de línea CRLF. */
    NEWLINE_CRLF(3);

    /**
     * Código persistible del modo (por ejemplo, para guardar en el workspace).
     */
    private int framingMode;
    
    private FramingMode(int framingMode){
        this.framingMode = framingMode;
    }
    
    /**
     * Devuelve el código persistible asociado al modo.
     *
     * @return código entero del modo
     */
    public int getFramigMode(){
        return this.framingMode;
    }
    
}
