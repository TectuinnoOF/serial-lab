/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tectuinno.seriallab.tools;

import java.util.Objects;
import java.util.Optional;

/**
 * Resultado de una operación que puede fallar sin usar excepciones como control de flujo.
 *
 * <p>Se usa para devolver:</p>
 * <ul>
 *   <li><b>Éxito</b>: {@code ok=true} y un {@code value} opcional.</li>
 *   <li><b>Fallo</b>: {@code ok=false} con {@code message} y/o {@code exception}.</li>
 * </ul>
 *
 * <p>Diseñada para capa de aplicación e infraestructura (por ejemplo, conexión a puertos COM),
 * permitiendo reportar errores claros a la UI.</p>
 *
 * @param <T> tipo del valor retornado en caso de éxito
 * @author pablo-g
 * @since 0.1.0
 */
public class Result<T> {
    
    private final boolean ok;
    private final T value;
    private final String message;
    private final Exception exception;
    
    private Result(boolean ok, T value, String message, Exception exception) {
        this.ok = ok;
        this.value = value;
        this.message = message;
        this.exception = exception;
    }
    
    /**
     * Crea un resultado exitoso sin valor.
     *
     * @param <T> tipo del valor
     * @return resultado exitoso
     */
    public static <T> Result<T> ok() {
        return new Result<>(true, null, null, null);
    }

    /**
     * Crea un resultado exitoso con valor.
     *
     * @param value valor retornado
     * @param <T> tipo del valor
     * @return resultado exitoso
     */
    public static <T> Result<T> ok(T value) {
        return new Result<>(true, value, null, null);
    }
    
    /**
     * Crea un resultado fallido con mensaje.
     *
     * @param message descripción del error
     * @param <T> tipo del valor
     * @return resultado fallido
     */
    public static <T> Result<T> fail(String message) {
        return new Result<>(false, null, Objects.requireNonNull(message, "message"), null);
    }

    /**
     * Crea un resultado fallido con mensaje y excepción asociada.
     *
     * @param message descripción del error
     * @param exception excepción capturada
     * @param <T> tipo del valor
     * @return resultado fallido
     */
    public static <T> Result<T> fail(String message, Exception exception) {
        return new Result<>(false, null, Objects.requireNonNull(message, "message"), exception);
    }
    
    /**
     * Indica si la operación fue exitosa.
     *
     * @return {@code true} si fue exitosa
     */
    public boolean isOk() {
        return ok;
    }

    /**
     * Devuelve el valor en caso de éxito.
     *
     * @return valor (puede ser {@code null} si el éxito no retorna valor)
     */
    public T getValue() {
        return value;
    }

    /**
     * Devuelve el mensaje asociado (normalmente presente en fallo).
     *
     * @return mensaje o {@code null} si no aplica
     */
    public String getMessage() {
        return message;
    }

    /**
     * Devuelve la excepción asociada (si se capturó una).
     *
     * @return excepción o {@code null} si no aplica
     */
    public Exception getException() {
        return exception;
    }

    /**
     * Devuelve el valor como {@link Optional}.
     *
     * @return optional del valor
     */
    public Optional<T> valueOptional() {
        return Optional.ofNullable(value);
    }

    /**
     * Devuelve la excepción como {@link Optional}.
     *
     * @return optional de la excepción
     */
    public Optional<Exception> exceptionOptional() {
        return Optional.ofNullable(exception);
    }

    @Override
    public String toString() {
        return "Result{" +
                "ok=" + ok +
                ", value=" + value +
                ", message='" + message + '\'' +
                ", exception=" + (exception != null ? exception.getClass().getSimpleName() : null) +
                '}';
    }
    
}
