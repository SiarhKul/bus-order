package com.example.busorder.models.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class RouteRequestDTO {
    private String departureCity;
    private String destinationCity;
}
