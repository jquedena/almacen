package com.almacen.error;

public class SinResultadoException extends BaseException {

    private static final long serialVersionUID = 1L;

    public SinResultadoException(String message, Throwable cause) {
        super(message, cause);
    }

    public SinResultadoException(String message) {
        super(message);
    }

}
