package com.tiklaisgelsin.api.infra.rest.common.exception;

public class MissingRequestPropertyException extends RuntimeException {

    public MissingRequestPropertyException(String message) {
        super(message);
    }

}
