/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/package-info.java to edit this template
 */

/**
 * <strong>Core/Dominio</strong> de <strong>Tectuinno Serial Lab</strong>.
 *
 * <h2>Objetivo</h2>
 * Contener el modelo de dominio, contratos (interfaces/puertos) y algoritmos puros
 * (framing/decoding/formatting), sin depender de UI (Swing) ni de infraestructura (jSerialComm, FS, sockets).
 *
 * <h2>Contenido</h2>
 * <table border="1" cellpadding="4" cellspacing="0">
 *   <caption>Elementos del Core</caption>
 *   <thead>
 *     <tr>
 *       <th>Categoría</th>
 *       <th>Ejemplos</th>
 *       <th>Propósito</th>
 *     </tr>
 *   </thead>
 *   <tbody>
 *     <tr>
 *       <td>Modelos</td>
 *       <td>{@code SerialConfig}, {@code Frame}, {@code Macro}</td>
 *       <td>Representación estable e independiente de UI/IO.</td>
 *     </tr>
 *     <tr>
 *       <td>Puertos</td>
 *       <td>{@code Transport}, {@code MacroRepository}, {@code LogWriter}</td>
 *       <td>Contratos que la infraestructura implementa.</td>
 *     </tr>
 *     <tr>
 *       <td>Procesamiento</td>
 *       <td>{@code FrameExtractor}, {@code Decoder}, {@code Sink}</td>
 *       <td>Pipeline reusable para consola/paquetes/gráficas/log.</td>
 *     </tr>
 *   </tbody>
 * </table>
 *
 * <h2>Principios</h2>
 * <ul>
 *   <li><strong>Pureza</strong>: clases del core deben ser unit-testables sin hardware.</li>
 *   <li><strong>Inmutabilidad preferida</strong> en modelos para reducir errores de concurrencia.</li>
 *   <li><strong>Extensibilidad</strong>: nuevos decoders y extractors deben añadirse sin romper APIs existentes.</li>
 * </ul>
 *
 * <h2>Ejemplo conceptual: pipeline</h2>
 * <pre>{@code
 * Transport -> (bytes RX) -> FrameExtractor -> Decoder(s) -> Sink(s)
 * }</pre>
 *
 * @apiNote El Core define el “lenguaje” del sistema (modelos/contratos). Cambios aquí impactan a todo.
 * @implSpec Core no debe importar paquetes de UI ni de infraestructura.
 * @since 0.1.0
 * @version 0.1.0-SNAPSHOT
 * @see com.tectuinno.seriallab.aplicacion
 * @see com.tectuinno.seriallab.infra
 */
package com.tectuinno.seriallab.core;
