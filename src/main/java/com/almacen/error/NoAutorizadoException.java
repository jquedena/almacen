package com.almacen.error;

public class NoAutorizadoException extends BaseException {

    private static final long serialVersionUID = 1L;

    public NoAutorizadoException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoAutorizadoException(String message) {
        super(message);
    }

}
