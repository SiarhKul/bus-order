package com.example.busorder.controllers;


import com.example.busorder.models.dto.BookingRequestDTO;
import com.example.busorder.models.entities.Booking;
import com.example.busorder.service.BookingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@Tag(name = "Booking")
@RestController()
@RequestMapping("/booking")
@AllArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @Operation(summary = "Create booking",
            description = "User creates order and save it to DB")
    @ApiResponse(responseCode = "200", description = "Booking was created")
    @PostMapping
    Booking saveBooking(@RequestBody BookingRequestDTO bookingRequestDTO ){

        Booking booking = bookingService.saveBooking(bookingRequestDTO);

        return booking;
    }
}
