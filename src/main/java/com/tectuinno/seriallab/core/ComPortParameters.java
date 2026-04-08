/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tectuinno.seriallab.core;

import java.util.Objects;

/**
 * mapea todos los parametros para inicializar y mantener una comunicación o
 * conexion activa con el dispositivo tty/usb seleccionado.
 *
 * @author pablo-g
 */
public class ComPortParameters {

    private final int baudRate;
    private final int dataBits;
    private final double stopBits; // 1.0, 1.5, 2.0
    private final ParityMode parityMode;
    private final FlowControlMode flowControlMode;

    // Timeouts (opcional, pero útil). 0 = sin timeout (según timeoutMode)
    private final int timeoutMode;
    private final int readTimeoutMs;
    private final int writeTimeoutMs;

    // Estados iniciales de líneas (opcional). Si NO_CHANGE, no se tocan.
    private final LineState dtr;
    private final LineState rts;

    private ComPortParameters(Builder b) {
        this.baudRate = b.baudRate;
        this.dataBits = b.dataBits;
        this.stopBits = b.stopBits;
        this.parityMode = b.parityMode;
        this.flowControlMode = b.flowControlMode;
        this.timeoutMode = b.timeoutMode;
        this.readTimeoutMs = b.readTimeoutMs;
        this.writeTimeoutMs = b.writeTimeoutMs;
        this.dtr = b.dtr;
        this.rts = b.rts;
    }

    public int getBaudRate() {
        return baudRate;
    }

    public int getDataBits() {
        return dataBits;
    }

    public double getStopBits() {
        return stopBits;
    }

    public ParityMode getParityMode() {
        return parityMode;
    }

    public FlowControlMode getFlowControlMode() {
        return flowControlMode;
    }

    public int getTimeoutMode() {
        return timeoutMode;
    }

    public int getReadTimeoutMs() {
        return readTimeoutMs;
    }

    public int getWriteTimeoutMs() {
        return writeTimeoutMs;
    }

    public LineState getDtr() {
        return dtr;
    }

    public LineState getRts() {
        return rts;
    }

    public static Builder builder() {
        return new Builder();
    }

    public enum LineState {
        NO_CHANGE, ON, OFF
    }

    public static final class Builder {

        // Defaults típicos (MVP)
        private int baudRate = 115200;
        private int dataBits = 8;
        private double stopBits = 1.0;
        private ParityMode parityMode = ParityMode.NONE;
        private FlowControlMode flowControlMode = FlowControlMode.NONE;

        // Timeout defaults: no bloquear (modo dependerá de infra, aquí solo guardamos)
        private int timeoutMode = 0;
        private int readTimeoutMs = 0;
        private int writeTimeoutMs = 0;

        private LineState dtr = LineState.NO_CHANGE;
        private LineState rts = LineState.NO_CHANGE;

        private Builder() {
        }

        public Builder baudRate(int baudRate) {
            this.baudRate = baudRate;
            return this;
        }

        public Builder dataBits(int dataBits) {
            this.dataBits = dataBits;
            return this;
        }

        public Builder stopBits(double stopBits) {
            this.stopBits = stopBits;
            return this;
        }

        public Builder parityMode(ParityMode parityMode) {
            this.parityMode = parityMode;
            return this;
        }

        public Builder flowControlMode(FlowControlMode flowControlMode) {
            this.flowControlMode = flowControlMode;
            return this;
        }

        public Builder timeoutMode(int timeoutMode) {
            this.timeoutMode = timeoutMode;
            return this;
        }

        public Builder readTimeoutMs(int readTimeoutMs) {
            this.readTimeoutMs = readTimeoutMs;
            return this;
        }

        public Builder writeTimeoutMs(int writeTimeoutMs) {
            this.writeTimeoutMs = writeTimeoutMs;
            return this;
        }

        public Builder dtr(LineState dtr) {
            this.dtr = dtr;
            return this;
        }

        public Builder rts(LineState rts) {
            this.rts = rts;
            return this;
        }

        public ComPortParameters build() {
            if (baudRate <= 0) {
                throw new IllegalArgumentException("baudRate inválido");
            }
            if (dataBits < 5 || dataBits > 8) {
                throw new IllegalArgumentException("dataBits inválido (5..8)");
            }
            if (stopBits != 1.0 && stopBits != 1.5 && stopBits != 2.0) {
                throw new IllegalArgumentException("stopBits inválido (1.0, 1.5, 2.0)");
            }

            Objects.requireNonNull(parityMode, "parityMode null");
            Objects.requireNonNull(flowControlMode, "flowControlMode null");
            Objects.requireNonNull(dtr, "dtr null");
            Objects.requireNonNull(rts, "rts null");

            if (readTimeoutMs < 0 || writeTimeoutMs < 0) {
                throw new IllegalArgumentException("timeouts no pueden ser negativos");
            }

            return new ComPortParameters(this);
        }
    }

}
