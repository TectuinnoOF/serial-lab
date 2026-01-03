/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.tectuinno.seriallab;

import com.tectuinno.seriallab.view.Principal;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author root
 */
public class Seriallab {

    public static void main(String[] args) {
        
        try{
            
            SwingUtilities.invokeLater(new Runnable(){
            
                @Override
                public void run(){
                    
                    Principal frame = new Principal();
                    frame.setLocationRelativeTo(null);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);
                    
                }
        
            });
            
        }catch(Exception ex){
            
            System.err.println(ex.getMessage());
            ex.printStackTrace(System.err);
            
        }
        
    }
}
