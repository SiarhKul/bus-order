package com.example.busorder.models.dto;

import lombok.*;


@Getter
@ToString
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {
    
    private String name;

    private String password;
}
