package com.example.busorder.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Cities {
    MINSK("Minsk"),
    GOMEL("Gomel"),
    BREST("Brest"),
    VITEBSK("Vitebsk"),
    GRODNO("Grodno"),
    MOGILEV("Mogilev");

    private final String name;

    Cities(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @JsonCreator
    public static Cities create (String name) {
        if(name == null) {
            throw new IllegalArgumentException("Enter any city");
        }
        for(Cities v : values()) {
            if(name.equals(v.getShortName())) {
                return v;
            }
        }
        throw new IllegalArgumentException("Enter correct city");
    }

    public String getShortName() {
        return name;
    }

}
