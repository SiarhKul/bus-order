package com.example.busorder.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum BookingStatus {
    FUTURE("Future"),
    PAST("Past");

    private final String status;

    @JsonValue
    public String getStatus() {
        return status;
    }

    BookingStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status;
    }

}
