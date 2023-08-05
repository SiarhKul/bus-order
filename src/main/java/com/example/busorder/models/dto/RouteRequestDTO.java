package com.example.busorder.models.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class RouteRequestDTO {

    @NotEmpty(message = "departureCity is not be empty")
    private String departureCity;

    @NotEmpty(message = "destinationCity is not be empty")
    private String destinationCity;
}
