package com.pozharsky.dmitri.exception;

public class ShapeException extends Exception {
    public ShapeException() {
        super();
    }

    public ShapeException(String message) {
        super(message);
    }

    public ShapeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ShapeException(Throwable cause) {
        super(cause);
    }
}
