/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tectuinno.seriallab.config;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLaf;
import javax.swing.UIManager;

/**
 * Utilidad de configuración para habilitar el <em>Look &amp; Feel</em> de FlatLaf en la aplicación.
 *
 * <p>
 * Esta clase centraliza la activación del tema visual (actualmente {@link com.formdev.flatlaf.FlatDarkLaf})
 * mediante {@link javax.swing.UIManager#setLookAndFeel(javax.swing.LookAndFeel)}. Debe invocarse
 * <strong>antes</strong> de crear y mostrar cualquier componente Swing, típicamente al inicio del
 * {@code main} o durante el bootstrap de la aplicación.
 * </p>
 *
 * <h2>Uso recomendado</h2>
 * <pre>{@code
 * public static void main(String[] args) {
 *     FlatlafConfig.enablingFlatlafUI();
 *     javax.swing.SwingUtilities.invokeLater(() -> new Principal().setVisible(true));
 * }
 * }</pre>
 *
 * <h2>Consideraciones</h2>
 * <ul>
 *   <li>Si el <em>Look &amp; Feel</em> se establece después de crear componentes, estos pueden no adoptar
 *       correctamente el estilo o requerir {@code SwingUtilities.updateComponentTreeUI(...)}.</li>
 *   <li>En caso de fallo, la aplicación continuará usando el <em>Look &amp; Feel</em> por defecto de Swing.</li>
 *   <li>Para un manejo de errores más consistente, se recomienda reemplazar {@code System.out/err}
 *       por un sistema de logging (por ejemplo, SLF4J) en iteraciones posteriores.</li>
 * </ul>
 *
 * @author root
 * @since 0.1.0
 */
public class FlatlafConfig {
    
    /**
     * Habilita el <em>Look &amp; Feel</em> de FlatLaf para la aplicación.
     *
     * <p>
     * Establece el tema {@link com.formdev.flatlaf.FlatDarkLaf} como <em>Look &amp; Feel</em> activo
     * mediante {@link javax.swing.UIManager#setLookAndFeel(javax.swing.LookAndFeel)}. En caso de
     * error (por ejemplo, si la clase del tema no está disponible o no es soportada), se captura
     * la excepción y se reporta por salida de error estándar; la UI permanecerá con el tema por defecto.
     * </p>
     *
     * <h3>Cuándo llamarlo</h3>
     * <ul>
     *   <li>Antes de instanciar cualquier {@code JFrame}/{@code JDialog}/{@code JPanel}.</li>
     *   <li>Al inicio del bootstrap de la aplicación (idealmente en la capa de configuración).</li>
     * </ul>
     *
     * <h3>Efectos secundarios</h3>
     * <ul>
     *   <li>Cambia globalmente el <em>Look &amp; Feel</em> de Swing para el proceso.</li>
     *   <li>Escribe mensajes de diagnóstico en {@code System.out} y errores en {@code System.err}.</li>
     * </ul>
     *
     * @apiNote Para mantener coherencia visual, no alternar <em>Look &amp; Feel</em> en tiempo de ejecución
     *          salvo que se implemente actualización del árbol de componentes.
     * @implNote Actualmente usa {@link com.formdev.flatlaf.FlatDarkLaf}. En el futuro se puede permitir
     *           selección de tema (claro/oscuro) desde preferencias.
     */
    public static void enablingFlatlafUI(){
        
        try{
            
            System.out.println("Enabling flatlaf look and feel");
            UIManager.setLookAndFeel(new FlatDarkLaf());
            System.out.println("Flatlaf UI Enabled");
            
        }catch(Exception er){
            System.err.println(er.getMessage());
            er.printStackTrace(System.err);
        }
        
        
    }
    
}
