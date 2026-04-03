/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tectuinno.seriallab.application;

import com.fazecast.jSerialComm.SerialPort;
import com.tectuinno.seriallab.core.PortInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author root
 */
public class SerialPortService {
    
    
    private SerialPortService(){
        
    }
    
    /**
     * Listado de todos los puertos conectados y disponibles.
     * los puertos disponibles se guardan en un {@code ArrayList<PortInfo>()}
     */
    public static List<PortInfo> listAvaiablePorts(){
        
        try{
            
            SerialPort[] ports = SerialPort.getCommPorts();            
            ArrayList<PortInfo> out = new ArrayList<>(ports.length);
            
            for(SerialPort p : ports){
                String desc = p.getDescriptivePortName();
                if(desc != null && desc.toLowerCase().contains("bluetooth")){
                    continue;
                }
                out.add(new PortInfo(p.getDescriptivePortName(),desc));
            }
            
            return out;
            
        }catch(Exception ex){
            ex.printStackTrace(System.err);
            return new ArrayList<>();
        }
        
    }
    
    public static void sendBytes(String systemPortName, int baud, byte[] data) throws IOException {
    	
    	//LoggerInfoManager.writteInInfoLogTxt("Preparando envio de trama a: " + systemPortName);
    	
        SerialPort port = SerialPort.getCommPort(systemPortName);
        port.setComPortParameters(baud, 8, SerialPort.ONE_STOP_BIT, SerialPort.NO_PARITY);
        port.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);

        if (!port.openPort()) {

            throw new IOException("No se pudo abrir el puerto: " + systemPortName);

        }
        try {
            int wrote = port.writeBytes(data, data.length);
            if (wrote != data.length) {
                throw new IOException("Escritura incompleta: " + wrote + " de " + data.length + " bytes.");
            }
            port.flushIOBuffers();
        } finally {
            port.closePort();
        }
    }
    
}
