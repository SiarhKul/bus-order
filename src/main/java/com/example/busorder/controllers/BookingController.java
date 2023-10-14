package com.example.busorder.controllers;


import com.example.busorder.exceptions.CreateEntityException;
import com.example.busorder.models.dto.BookingRequestDTO;
import com.example.busorder.models.entities.Booking;
import com.example.busorder.service.serviceInterfaces.BookingService;
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


@Tag(name = "Booking")
@RestController()
@RequestMapping("/booking")
@AllArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @Operation(summary = "Create booking[Admin]",
            description = "User creates order and save it to DB")
    @ApiResponse(responseCode = "200", description = "Booking was created")
    @PostMapping
    Booking saveBooking(@RequestBody @Valid BookingRequestDTO bookingRequestDTO,
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

        Booking booking = bookingService.saveBooking(bookingRequestDTO);
        return booking;
    }
}
/*
* depBusStation
* desBusStation*
* * */