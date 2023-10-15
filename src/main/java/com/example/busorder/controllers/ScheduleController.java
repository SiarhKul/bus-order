package com.example.busorder.controllers;


import com.example.busorder.exceptions.CreateEntityException;
import com.example.busorder.models.dto.ScheduleResponseDTO;
import com.example.busorder.models.dto.TripDTO;
import com.example.busorder.service.serviceInterfaces.ScheduleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Schedule")
@RestController
@RequestMapping("/schedule")
@AllArgsConstructor
public class ScheduleController {

    private final ScheduleService connectionService;

    @Operation(summary = "Get schedule of bus",
            description = "User gets some data about the bus schedule." +
                    "Proved destination time, departure time, time, amount of passengers")
    @ApiResponse(responseCode = "200", description = "A Successfully response provides bus schedule date")
    @PostMapping
    public ScheduleResponseDTO getSchedule(@RequestBody @Valid TripDTO tripDTO,
                                           BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            StringBuilder errorMsg = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors) {
                errorMsg.append(error.getField())
                        .append(" - ")
                        .append(error.getDefaultMessage())
                        .append(";");
            }
            throw new CreateEntityException(errorMsg.toString());
        }
        return connectionService.getSchedule(tripDTO);
    }


}
