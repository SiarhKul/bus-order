package com.example.busorder;

public enum Cities {
    MINSK("Minsk"),
    BREST("Brest"),
    GOMEL("Gomel"),
    VITEBSK("Vitebsk"),
    GRODNO("Grodno"),
    MOGILEV("Mogilev");

    private String name;

    Cities(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }
}
