package com.example.busorder.exceptions;

public class RecordExistsInTableException extends RuntimeException {
    public RecordExistsInTableException(String msg) {
        super(msg);
    }
}
