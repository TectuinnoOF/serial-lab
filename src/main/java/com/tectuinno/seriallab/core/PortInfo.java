/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tectuinno.seriallab.core;

/**
 *
 * @author root
 */
public class PortInfo implements java.io.Serializable{
    
    public String systemName;
    public String descriptiveName;
    
    public PortInfo(String systemName, String descriptiveName){
        this.systemName = systemName;
        this.descriptiveName = descriptiveName;
    }
    
    public PortInfo(){}
    
    @Override
    public String toString(){
        return this.descriptiveName != null && !this.descriptiveName.isBlank()?
                this.descriptiveName + "(" + this.systemName + ")" :
                this.systemName;
    }
    
}
