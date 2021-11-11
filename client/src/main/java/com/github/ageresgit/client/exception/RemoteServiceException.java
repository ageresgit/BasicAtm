package com.github.ageresgit.client.exception;

public class RemoteServiceException extends RuntimeException {
    public RemoteServiceException() {
        super();
    }

    public RemoteServiceException(String message) {
        super(message);
    }

    public RemoteServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public RemoteServiceException(Throwable cause) {
        super(cause);
    }

    protected RemoteServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
