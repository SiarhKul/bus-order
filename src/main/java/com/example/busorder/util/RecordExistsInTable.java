package com.example.busorder.util;

public class RecordExistsInTable extends RuntimeException {
    public RecordExistsInTable(String msg) {
        super(msg);
    }
}
