/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.tectuinno.seriallab.core;

/**
 * <h2>Flow Controll</h2>
 * El Flow Controll sirve como un mecanismo para evitar la perdida de datos cuando un lado (Receptor) no puede procesar o almacenar bytes tan rápido
 * como el otro lado (Emisor) los envia.
 * 
 * Define los distintos modos en los que se puede configurar un espacio de trabajo para el flow controll
 * <ul>
 *  <li>NONE: sin control de flujo</li>
 *  <li>RTS/CTS: Hardware flow controll -> uso de lineas adicionales del estandar serial (Aparte de TX/RX y gnd)
 *  <ul>
 *      <li>RTS: Solicitar permiso para enviar</li>
 *      <li>CTS: linea usada para dar permiso o indicar que es seguro enviar</li>
 *  </ul>
 *  </li>
 *  <li>XON/XOFF: Control por software
 *      <ul>
 *          <li>receptor envia XOFF cuando se llena el buffer</li>
 *          <li>emisor detiene el envio</li>
 *          <li>receptor envia XON cuando puede seguir recibiendo</li>
 *      </ul>
 *  </li>
 * </ul>
 * @author root
 */
public enum FlowControlMode {
    
    NONE(1),
    RTS_CTS(2),
    XON_XOFF(3);
    
    
    private int controlMode;
    
    private FlowControlMode(int controlMode){
        this.controlMode = controlMode;
    }
    
    public int getControlMode(){
        return this.controlMode;
    }
    
}
