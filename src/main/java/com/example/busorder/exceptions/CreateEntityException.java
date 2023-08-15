package com.example.busorder.exceptions;

public class CreateEntityException extends RuntimeException {
    public CreateEntityException(String msg){
        super(msg);
    }
}
