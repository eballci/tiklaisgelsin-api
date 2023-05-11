package com.tiklaisgelsin.api.domain.common.exception;

public class MissingEntityException extends RuntimeException {
    public MissingEntityException(String message) {
        super(message);
    }
}
