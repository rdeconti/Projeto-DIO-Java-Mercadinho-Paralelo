package com.rdeconti.mercadinho.exception;

public class ResourceAlreadyExistsException extends Exception {

    public ResourceAlreadyExistsException() {
    }

    public ResourceAlreadyExistsException(String msg) {
        super(msg);
    }
}
