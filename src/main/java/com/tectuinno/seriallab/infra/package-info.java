/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/package-info.java to edit this template
 */

/**
 * Capa de <strong>infraestructura</strong> (adaptadores) de <strong>Tectuinno Serial Lab</strong>.
 *
 * <h2>Rol</h2>
 * Proveer implementaciones concretas de los puertos definidos en {@code core}:
 * transporte serial (jSerialComm), TCP/UDP, repositorios en archivo, logging a disco, etc.
 *
 * <h2>Qué vive aquí</h2>
 * <ul>
 *   <li>Implementaciones de {@code core.Transport} (ej. {@code JSerialCommTransport}).</li>
 *   <li>Repositorios concretos: {@code JsonMacroRepository} implementando {@code core.MacroRepository}.</li>
 *   <li>Writers concretos: {@code CsvLogWriter}/{@code JsonLogWriter} implementando {@code core.LogWriter}.</li>
 * </ul>
 *
 * <h2>Reglas de dependencia</h2>
 * <ul>
 *   <li>Puede depender de: {@code core}, librerías externas (jSerialComm), {@code java.net}, {@code java.nio}.</li>
 *   <li>No debe depender de: {@code vista} / Swing.</li>
 * </ul>
 *
 * <h2>Estándares de calidad</h2>
 * <ul>
 *   <li>Normalizar excepciones de librerías externas a tipos propios del sistema (ver {@code herramientas}).</li>
 *   <li>Ser tolerante a fallos: cierre seguro de recursos, reconexión opcional, timeouts razonables.</li>
 *   <li>Minimizar acoplamiento: toda dependencia externa debe quedar encapsulada aquí.</li>
 * </ul>
 *
 * @apiNote Esta capa es sustituible. Si cambia la librería serial, el impacto debe limitarse a {@code infra}.
 * @implNote Recomendado: wrappers finos para facilitar pruebas (mocks) en {@code aplicacion/core}.
 * @since 0.1.0
 * @version 0.1.0-SNAPSHOT
 * @see com.tectuinno.seriallab.core
 */
package com.tectuinno.seriallab.infra;
