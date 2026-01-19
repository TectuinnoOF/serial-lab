/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.tectuinno.seriallab.core;

/**
 *
 * @author root
 */
public enum TxEndingMode {
    
    NONE(1),
    CR(2),
    LF(3),
    CRLF(4);
    
    /**
     * Representa el finalizador de linea
     */
    private int endingMode;
    
    private TxEndingMode(int endingMode){
        this.endingMode = endingMode;
    }
    
    public int getEndingMode(){
        return this.endingMode;
    }
    
}
