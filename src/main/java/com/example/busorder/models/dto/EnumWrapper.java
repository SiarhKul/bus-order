package com.example.busorder.models.dto;

import jakarta.validation.constraints.NotNull;


public record EnumWrapper<T extends Enum<T>>(@NotNull T key, String name) {

}