/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.tectuinno.seriallab.core;

/**
 * <strong>Define las distintas formas en las que se puede mostrar el texto o mensaje en la consola</strong>
 * <p>
 * pueden ser...
 *  <ul>
 *      <li>Modo ASCII</li>
 *      <li>Modo Hexadecimal</li>
 *      <li>Ambos: ASCII y Hex para cuando sea requerido</li>
 *  </ul>
 * </p>
 * @author Pablo_g
 */
public enum ConsoleDisplayMode {
    
    ASCII(1),
    HEXADECIMAL(2),
    ASCII_HEX(3);
    
    private int displayMode;
    
    private ConsoleDisplayMode(int displayMode){
        this.displayMode = displayMode;
    }
    
    public int getDisplayMode(){
        return this.displayMode;
    }
    
}
