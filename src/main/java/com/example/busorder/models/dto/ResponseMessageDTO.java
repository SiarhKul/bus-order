package com.example.busorder.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ResponseMessageDTO {

    String message;
    Boolean status;
}
