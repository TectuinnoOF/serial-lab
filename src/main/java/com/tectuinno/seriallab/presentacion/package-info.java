/**
 * Capa de <strong>presentación</strong> (lógica de formularios) para <strong>Tectuinno Serial Lab</strong>.
 *
 * <h2>Rol</h2>
 * Actúa como puente entre la UI ({@code vista}) y la aplicación ({@code aplicacion}):
 * valida entradas simples, coordina eventos, traduce modelos de dominio a modelos de vista
 * (ViewModels) y controla el estado visible.
 *
 * <h2>Qué debe vivir aquí</h2>
 * <ul>
 *   <li><strong>Presenters/Controllers</strong> por pantalla: {@code SerialTabPresenter}, {@code MacrosPresenter}.</li>
 *   <li><strong>ViewModels</strong>: DTOs orientados a UI (texto listo para mostrar, flags, etc.).</li>
 *   <li>Validaciones simples: campos requeridos, rangos básicos, formato superficial.</li>
 * </ul>
 *
 * <h2>Qué NO debe vivir aquí</h2>
 * <ul>
 *   <li>Acceso a hardware o red (eso pertenece a {@code infra}).</li>
 *   <li>Algoritmos de decodificación/framing (eso pertenece a {@code core}).</li>
 *   <li>Orquestación compleja de sesión (eso pertenece a {@code aplicacion}).</li>
 * </ul>
 *
 * <h2>Dependencias permitidas</h2>
 * <table border="1" cellpadding="4" cellspacing="0">
 *   <caption>Dependencias recomendadas</caption>
 *   <thead>
 *     <tr>
 *       <th>Paquete</th>
 *       <th>Uso</th>
 *       <th>Prohibiciones</th>
 *     </tr>
 *   </thead>
 *   <tbody>
 *     <tr>
 *       <td>{@code aplicacion}</td>
 *       <td>Invocar casos de uso y recibir estado de sesión.</td>
 *       <td>No ejecutar IO directo.</td>
 *     </tr>
 *     <tr>
 *       <td>{@code core}</td>
 *       <td>Consumir modelos (ej. {@code SerialConfig}, {@code Macro}).</td>
 *       <td>No implementar infraestructura.</td>
 *     </tr>
 *     <tr>
 *       <td>{@code vista}</td>
 *       <td>Debe ser unidireccional: UI usa presenters; presenters no dependen de UI concreta si se puede.</td>
 *       <td>Evitar imports de Swing aquí (si se busca desacoplar).</td>
 *     </tr>
 *   </tbody>
 * </table>
 *
 * <h2>Patrones sugeridos</h2>
 * <ul>
 *   <li>MVP (Model-View-Presenter) o Presentation Model.</li>
 *   <li>Observers/listeners para notificar cambios de estado a la UI.</li>
 * </ul>
 *
 * @apiNote Esta capa debe ser ligera y predecible; su complejidad debe crecer lentamente.
 * @implNote Si se requiere un scheduler/debouncer para UI, usar utilidades en {@code herramientas}.
 * @since 0.1.0
 * @version 0.1.0-SNAPSHOT
 * @see com.tectuinno.seriallab.aplicacion
 * @see com.tectuinno.seriallab.core
 */
package com.tectuinno.seriallab.presentacion;
