/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tectuinno.seriallab.application;

import com.fazecast.jSerialComm.SerialPort;
import com.tectuinno.seriallab.core.ComPortParameters;
import com.tectuinno.seriallab.core.FlowControlMode;
import com.tectuinno.seriallab.core.ParityMode;
import com.tectuinno.seriallab.core.PortInfo;
import com.tectuinno.seriallab.tools.Result;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Servicio de infraestructura/aplicación para gestionar conexión y
 * configuración de puertos seriales (UART).
 *
 * <p>
 * Centraliza:</p>
 * <ul>
 * <li>apertura/cierre del puerto activo,</li>
 * <li>mapeo de {@code ComPortParameters} a la API de la librería serial (por
 * ejemplo jSerialComm),</li>
 * <li>manejo de errores devolviendo {@code Result} en lugar de excepciones en
 * la UI.</li>
 * </ul>
 *
 * <p>
 * Notas de uso:</p>
 * <ul>
 * <li>Mantiene un único puerto activo (singleton estático) para la sesión
 * actual.</li>
 * <li>Las llamadas a conexión están sincronizadas para evitar estados
 * inconsistentes.</li>
 * </ul>
 *
 * @author pablo-g
 * @since 0.1.0
 * @see com.tectuinno.seriallab.core.ComPortParameters
 * @see com.tectuinno.seriallab.tools.Result
 */
public class SerialPortService {

    private static volatile SerialPort activePort;

    private SerialPortService() {

    }

    public static SerialPort getActivePort() {

        return activePort;

    }

    /**
     * Listado de todos los puertos conectados y disponibles. los puertos
     * disponibles se guardan en un {@code ArrayList<PortInfo>()}
     *
     * @return
     */
    public static List<PortInfo> listAvaiablePorts() {

        try {

            SerialPort[] ports = SerialPort.getCommPorts();
            ArrayList<PortInfo> out = new ArrayList<>(ports.length);

            for (SerialPort p : ports) {
                String desc = p.getDescriptivePortName();
                if (desc != null && desc.toLowerCase().contains("bluetooth")) {
                    continue;
                }
                out.add(new PortInfo(p.getSystemPortName(), desc));
            }

            return out;

        } catch (Exception ex) {
            ex.printStackTrace(System.err);
            return new ArrayList<>();
        }

    }

    /**
     * Intenta abrir y configurar el puerto serial indicado.
     *
     * @param systemPortName nombre del puerto (COMx o /dev/tty*)
     * @param parameters parámetros UART (baud, dataBits, parity, stopBits,
     * flow, etc.)
     * @return Result con el puerto abierto en éxito o mensaje/exception en
     * fallo
     */
    public static Result<SerialPort> tryConnect(String systemPortName, ComPortParameters parameters) {

        if (systemPortName == null || systemPortName.trim().isEmpty()) {
            return Result.fail("Nombre de puerto inválido.");
        }
        Objects.requireNonNull(parameters, "parameters");

        final String portName = systemPortName.trim();

        synchronized (SerialPortService.class) {
            try {
                // Cierra puerto previo si existe
                if (activePort != null && activePort.isOpen()) {
                    activePort.closePort();
                }
                activePort = null;

                SerialPort port = SerialPort.getCommPort(portName);

                // --- UART parameters ---
                port.setComPortParameters(
                        parameters.getBaudRate(),
                        parameters.getDataBits(),
                        mapStopBits(parameters.getStopBits()),
                        mapParity(parameters.getParityMode())
                );

                // --- Flow control ---
                port.setFlowControl(mapFlowControl(parameters.getFlowControlMode()));

                // --- Timeouts (si aplica) ---
                if (parameters.getTimeoutMode() != 0) {
                    port.setComPortTimeouts(
                            parameters.getTimeoutMode(),
                            parameters.getReadTimeoutMs(),
                            parameters.getWriteTimeoutMs()
                    );
                }

                // --- Open ---
                if (!port.openPort()) {
                    // Mensaje útil sin asumir API interna de error codes
                    return Result.fail("No se pudo abrir el puerto '" + portName
                            + "'. Posibles causas: puerto ocupado, permisos insuficientes o puerto inexistente.");
                }

                // --- DTR/RTS (si aplica) ---
                applyLineState(port, parameters);

                activePort = port;
                return Result.fail(portName).ok(port);

            } catch (Exception ex) {
                // Asegura cleanup
                try {
                    if (activePort != null && activePort.isOpen()) {
                        activePort.closePort();
                    }
                } catch (Exception ignored) {
                }

                activePort = null;
                return Result.fail("Error al conectar con el puerto '" + portName + "': " + ex.getMessage(), ex);
            }
        }
    }

    private static int mapParity(ParityMode parityMode) {
        return switch (parityMode) {
            case NONE ->
                SerialPort.NO_PARITY;
            case EVEN ->
                SerialPort.EVEN_PARITY;
            case ODD ->
                SerialPort.ODD_PARITY;
        };
    }

    private static int mapStopBits(double stopBits) {
        if (stopBits == 1.0) {
            return SerialPort.ONE_STOP_BIT;
        }
        if (stopBits == 1.5) {
            return SerialPort.ONE_POINT_FIVE_STOP_BITS;
        }
        if (stopBits == 2.0) {
            return SerialPort.TWO_STOP_BITS;
        }
        // Validado en builder, pero por seguridad:
        return SerialPort.ONE_STOP_BIT;
    }

    private static int mapFlowControl(FlowControlMode mode) {
        return switch (mode) {
            case NONE ->
                SerialPort.FLOW_CONTROL_DISABLED;
            case RTS_CTS ->
                SerialPort.FLOW_CONTROL_RTS_ENABLED | SerialPort.FLOW_CONTROL_CTS_ENABLED;
            case XON_XOFF ->
                SerialPort.FLOW_CONTROL_XONXOFF_IN_ENABLED | SerialPort.FLOW_CONTROL_XONXOFF_OUT_ENABLED;
        };
    }

    private static void applyLineState(SerialPort port, ComPortParameters parameters) {
        switch (parameters.getDtr()) {
            case ON ->
                port.setDTR();
            case OFF ->
                port.clearDTR();
            case NO_CHANGE -> {
                /* no-op */ }
        }
        switch (parameters.getRts()) {
            case ON ->
                port.setRTS();
            case OFF ->
                port.clearRTS();
            case NO_CHANGE -> {
                /* no-op */ }
        }
    }

}
