package com.github.ageresgit.client.exception;

public class AtmServiceException extends RuntimeException {
    public AtmServiceException() {
    }

    public AtmServiceException(String message) {
        super(message);
    }

    public AtmServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public AtmServiceException(Throwable cause) {
        super(cause);
    }

    public AtmServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
