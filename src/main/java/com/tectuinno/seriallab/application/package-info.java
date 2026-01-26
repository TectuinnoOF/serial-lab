/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/package-info.java to edit this template
 */
/**
 * Capa de aplicación: casos de uso y coordinación de la ejecución.
 *
 * <p>Este paquete implementa la lógica que orquesta el comportamiento del sistema sin acoplarse a la UI.
 * Aquí viven los <em>casos de uso</em> (crear/abrir workspace, conectar/desconectar, enviar datos, aplicar
 * configuración) y los componentes que coordinan el flujo RX/TX (framing, formateo, logging y estado de sesión).</p>
 *
 * <h2>Responsabilidades</h2>
 * <ul>
 *   <li>Orquestar casos de uso a partir de modelos del dominio ({@code core}).</li>
 *   <li>Gestionar el estado de sesión (conectado, desconectado, error) y notificar cambios.</li>
 *   <li>Coordinar el pipeline de datos: recepción de bytes, segmentación (framing) y entrega a vistas/loggers.</li>
 *   <li>Aplicar configuraciones y decidir cuándo se requiere reconexión del transporte.</li>
 * </ul>
 *
 * <h2>Dependencias</h2>
 * <ul>
 *   <li>Depende de {@code com.tectuinno.seriallab.core} (modelos, enums e interfaces).</li>
 *   <li>Consume implementaciones concretas desde {@code infra} a través de interfaces del {@code core}.</li>
 *   <li>No depende de {@code view} ni de clases Swing.</li>
 * </ul>
 *
 * @since 0.1.0
 * @author Pablo_g
 */
package com.tectuinno.seriallab.application;
