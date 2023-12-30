package com.cdac.billing.exception;

public class CustomerServiceException extends RuntimeException {

    public CustomerServiceException() {
        super();
    }

    public CustomerServiceException(Integer errorCode, Throwable cause) {
        super(String.valueOf(errorCode), cause);
    }

    public CustomerServiceException(Integer errorCode) {
        super(String.valueOf(errorCode));
    }
    public CustomerServiceException(String errorCode) {
        super(errorCode);
    }

    public CustomerServiceException(Integer errorCode, String message) {
        super("Error Code: " + errorCode + ", Message: " + message);
    }
}