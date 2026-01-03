/**
 * Capa de presentación visual (UI) de <strong>Tectuinno Serial Lab</strong>.
 *
 * <h2>Responsabilidad</h2>
 * Renderizar y gestionar componentes Swing (ventanas, paneles, diálogos y widgets),
 * manteniendo la UI libre de lógica de negocio y libre de dependencias a la infraestructura
 * (por ejemplo, acceso directo a jSerialComm o sockets).
 *
 * <h2>Contenido típico</h2>
 * <table border="1" cellpadding="4" cellspacing="0">
 *   <caption>Elementos recomendados en esta capa</caption>
 *   <thead>
 *     <tr>
 *       <th>Tipo</th>
 *       <th>Ejemplos</th>
 *       <th>Notas</th>
 *     </tr>
 *   </thead>
 *   <tbody>
 *     <tr>
 *       <td>Ventanas/Frames</td>
 *       <td>{@code MainFrame}</td>
 *       <td>Punto de entrada visual de la aplicación.</td>
 *     </tr>
 *     <tr>
 *       <td>Paneles</td>
 *       <td>{@code SerialTabPanel}, {@code MacrosPanel}, {@code ChartsPanel}</td>
 *       <td>Contienen controles y layout; delegan acciones a {@code presentacion}.</td>
 *     </tr>
 *     <tr>
 *       <td>Diálogos</td>
 *       <td>{@code SettingsDialog}, {@code AboutDialog}</td>
 *       <td>Interacción modal y configuración.</td>
 *     </tr>
 *     <tr>
 *       <td>Componentes reutilizables</td>
 *       <td>{@code ConsoleView}, {@code HexTextField}</td>
 *       <td>Widgets con comportamiento encapsulado, sin lógica de negocio.</td>
 *     </tr>
 *   </tbody>
 * </table>
 *
 * <h2>Reglas de dependencia</h2>
 * <ul>
 *   <li>Puede depender de: {@code com.tectuinno.seriallab.presentacion}.</li>
 *   <li>No debe depender de: {@code infra}, ni usar librerías de comunicación directamente.</li>
 * </ul>
 *
 * <h2>Concurrencia (Swing EDT)</h2>
 * <ul>
 *   <li>Toda actualización de componentes debe ocurrir en el <em>Event Dispatch Thread</em> (EDT).</li>
 *   <li>Evitar trabajo pesado en listeners. Delegar a {@code presentacion} y esta a {@code aplicacion}.</li>
 * </ul>
 *
 * <h2>Buenas prácticas</h2>
 * <ul>
 *   <li>Preferir <em>batch updates</em> (actualizaciones por lote) en consolas para evitar freezes.</li>
 *   <li>Usar buffers (ring buffer) para limitar memoria cuando el stream es constante.</li>
 *   <li>Mantener componentes testables: lógica mínima, estado visual claro.</li>
 * </ul>
 *
 * @apiNote Esta capa es <strong>UI-only</strong>. No expone APIs de dominio.
 * @implNote Los estilos (FlatLaf) se inicializan desde {@code configuracion}, no aquí.
 * @since 0.1.0
 * @version 0.1.0-SNAPSHOT
 * @see com.tectuinno.seriallab.presentacion
 * @see com.tectuinno.seriallab.configuracion
 */
package com.tectuinno.seriallab.view;
