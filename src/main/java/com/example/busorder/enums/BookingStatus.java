package com.example.busorder.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum BookingStatus {
    FUTURE("Future"),
    PAST("Past");

    private final String status;

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

    @JsonCreator
    public static BookingStatus create (String name) {
        if(name == null) {
            throw new IllegalArgumentException("Enter any city");
        }
        for(BookingStatus status : values()) {
            if(name.equals(status.getStatus())) {
                return status;
            }
        }
        throw new IllegalArgumentException("Enter correct city");
    }
}
