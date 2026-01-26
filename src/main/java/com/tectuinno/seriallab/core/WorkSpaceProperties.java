/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tectuinno.seriallab.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.awt.DisplayMode;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <summary>Usada para mapear los parámetros configurables de un espacio de
 * trabajo.</summary>
 * <p>
 * Se almacenan todos los datos tanto genéricos como los parámetros técnicos de
 * configuración correspondientes a la comunicación serial</p>
 *
 * @author Pablo_g
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WorkSpaceProperties implements Serializable {

    private String name;
    private String author;
    private LocalDateTime createdAt;
    private String path;
    private String version;
    private String description;

    // --- Configuración UART ---
    private SerialConfig serial;

    // --- Envío y consola ---
    private TxEndingMode txEndingMode;
    private DisplayMode displayMode;
    private boolean timestampEnabled;

    // --- Framing ---
    private FramingMode framingMode;

    public WorkSpaceProperties(String name, String author, LocalDateTime createdAt, String path, String version, String description, SerialConfig serial, TxEndingMode txEndingMode, DisplayMode displayMode, boolean timestampEnabled, FramingMode framingMode) {
        this.name = name;
        this.author = author;
        this.createdAt = createdAt;
        this.path = path;
        this.version = version;
        this.description = description;
        this.serial = serial;
        this.txEndingMode = txEndingMode;
        this.displayMode = displayMode;
        this.timestampEnabled = timestampEnabled;
        this.framingMode = framingMode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SerialConfig getSerial() {
        return serial;
    }

    public void setSerial(SerialConfig serial) {
        this.serial = serial;
    }

    public TxEndingMode getTxEndingMode() {
        return txEndingMode;
    }

    public void setTxEndingMode(TxEndingMode txEndingMode) {
        this.txEndingMode = txEndingMode;
    }

    public DisplayMode getDisplayMode() {
        return displayMode;
    }

    public void setDisplayMode(DisplayMode displayMode) {
        this.displayMode = displayMode;
    }

    public boolean isTimestampEnabled() {
        return timestampEnabled;
    }

    public void setTimestampEnabled(boolean timestampEnabled) {
        this.timestampEnabled = timestampEnabled;
    }

    public FramingMode getFramingMode() {
        return framingMode;
    }

    public void setFramingMode(FramingMode framingMode) {
        this.framingMode = framingMode;
    }

    @Override
    public String toString() {
        return "WorkSpaceProperties{" + "name=" + name + ", author=" + author + ", createdAt=" + createdAt + ", path=" + path + ", version=" + version + ", description=" + description + ", serial=" + serial + ", txEndingMode=" + txEndingMode + ", displayMode=" + displayMode + ", timestampEnabled=" + timestampEnabled + ", framingMode=" + framingMode + '}';
    }

    /**
     * Constructor vacio para serialización con {@code ObjectMapper}
     */
    public WorkSpaceProperties() {
    }

    /**
     * Dedicada a mapear y guardar la configuración de la comunicación serial
     * por protocolo UART.
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class SerialConfig {

        private int baudRate = 115200;
        private int dataBits = 8;
        private ParityMode parityMode = ParityMode.NONE;

        /**
         * Stop bits: 1.0, 1.5 o 2.0
         */
        private double stopBits = 1.0d;

        private FlowControlMode flowControlMode = FlowControlMode.NONE;

        public SerialConfig() {
        }

        public int getBaudRate() {
            return baudRate;
        }

        public void setBaudRate(int baudRate) {
            this.baudRate = baudRate;
        }

        public int getDataBits() {
            return dataBits;
        }

        public void setDataBits(int dataBits) {
            this.dataBits = dataBits;
        }

        public ParityMode getParityMode() {
            return parityMode;
        }

        public void setParityMode(ParityMode parityMode) {
            this.parityMode = parityMode;
        }

        public double getStopBits() {
            return stopBits;
        }

        public void setStopBits(double stopBits) {
            this.stopBits = stopBits;
        }

        public FlowControlMode getFlowControlMode() {
            return flowControlMode;
        }

        public void setFlowControlMode(FlowControlMode flowControlMode) {
            this.flowControlMode = flowControlMode;
        }

    }

}
