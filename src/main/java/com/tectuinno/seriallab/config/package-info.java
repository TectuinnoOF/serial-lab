/**
 * Capa de <strong>configuración y bootstrap</strong> de <strong>Tectuinno Serial Lab</strong>.
 *
 * <h2>Rol</h2>
 * Centraliza:
 * <ul>
 *   <li>Preferencias/ajustes de usuario (puerto, baudrate, formato, tema).</li>
 *   <li>Inicialización de look &amp; feel (por ejemplo, FlatLaf).</li>
 *   <li>Rutas de trabajo (logs, macros, exportaciones).</li>
 *   <li><strong>Composición</strong> del sistema (wiring): crear infra, casos de uso, presenters y UI.</li>
 * </ul>
 *
 * <h2>Clases típicas</h2>
 * <ul>
 *   <li>{@code AppConfig}: defaults y constantes de configuración.</li>
 *   <li>{@code PreferencesService}: carga/guarda settings (Preferences/JSON/Properties).</li>
 *   <li>{@code LookAndFeelConfig}: aplica FlatLaf y reglas visuales globales.</li>
 *   <li>{@code AppBootstrap}: ensambla dependencias y arranca {@code MainFrame}.</li>
 * </ul>
 *
 * <h2>Reglas</h2>
 * <ul>
 *   <li>Puede conocer {@code infra} para instanciar implementaciones concretas.</li>
 *   <li>No debe contener lógica de negocio ni procesamiento de frames.</li>
 * </ul>
 *
 * <h2>Ejemplo conceptual: bootstrap</h2>
 * <pre>{@code
 * LookAndFeelConfig.apply();
 * var repos = new JsonMacroRepository(...);
 * var transport = new JSerialCommTransport(...);
 * var useCases = new OpenSerialUseCase(transport, ...);
 * var presenter = new SerialTabPresenter(useCases, ...);
 * var frame = new MainFrame(presenter, ...);
 * frame.setVisible(true);
 * }</pre>
 *
 * @apiNote Todo “wiring” debe ocurrir aquí, no en {@code vista} ni en {@code core}.
 * @implNote Mantener el bootstrap determinista y fácil de depurar.
 * @since 0.1.0
 * @version 0.1.0-SNAPSHOT
 * @see com.tectuinno.seriallab.vista
 * @see com.tectuinno.seriallab.infra
 */
package com.tectuinno.seriallab.config;
