package com.example.busorder.models.dto;

import lombok.*;

@Getter
@ToString
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientSaveDTO {

//    private Integer id;

    private String name;

    private String surname;

    private int mobilePhone;

    private String email;

    private String password;
}
