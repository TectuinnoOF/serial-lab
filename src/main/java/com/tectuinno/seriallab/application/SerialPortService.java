/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tectuinno.seriallab.application;

import com.fazecast.jSerialComm.SerialPort;
import com.tectuinno.seriallab.core.PortInfo;
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
     * @return 
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
    
    public static boolean tryConnect(String systemPortName){
        
        return false;
        
    }
    
}
