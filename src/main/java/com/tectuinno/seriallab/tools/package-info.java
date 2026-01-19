/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/package-info.java to edit this template
 */

/**
 * Utilidades transversales (<strong>herramientas</strong>) de <strong>Tectuinno Serial Lab</strong>.
 *
 * <h2>Objetivo</h2>
 * Proveer helpers reutilizables sin invadir responsabilidades de las capas principales.
 * Esta carpeta debe permanecer pequeña y con propósito claro.
 *
 * <h2>Qué debe vivir aquí</h2>
 * <table border="1" cellpadding="4" cellspacing="0">
 *   <caption>Utilidades recomendadas</caption>
 *   <thead>
 *     <tr>
 *       <th>Tipo</th>
 *       <th>Ejemplos</th>
 *       <th>Uso</th>
 *     </tr>
 *   </thead>
 *   <tbody>
 *     <tr>
 *       <td>Formateo/codec</td>
 *       <td>{@code HexCodec}, {@code ByteFormat}</td>
 *       <td>Conversión bytes↔hex, escapes ASCII, etc.</td>
 *     </tr>
 *     <tr>
 *       <td>Errores</td>
 *       <td>{@code AppException}, {@code Result<T>}</td>
 *       <td>Contrato de errores estable para UI y app.</td>
 *     </tr>
 *     <tr>
 *       <td>Concurrencia</td>
 *       <td>{@code Debouncer}, {@code Threading}</td>
 *       <td>Schedulers, buffers, estrategias de actualización por lote.</td>
 *     </tr>
 *     <tr>
 *       <td>Validación</td>
 *       <td>{@code Validation}</td>
 *       <td>Validaciones reutilizables (sin depender de Swing).</td>
 *     </tr>
 *   </tbody>
 * </table>
 *
 * <h2>Anti-patrón</h2>
 * Evitar que {@code tools} se convierta en un “cajón de sastre”.
 * Si una utilidad es específica de UI, ubicarla en {@code view} o crear un subpaquete claramente UI-bound.
 *
 * @implNote Preferir funciones puras y clases estáticas pequeñas cuando aplique.
 * @since 0.1.0
 * @version 0.1.0-SNAPSHOT
 */
package com.tectuinno.seriallab.tools;
