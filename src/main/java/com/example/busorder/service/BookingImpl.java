package com.example.busorder.service;

import com.example.busorder.models.dto.BookingRequestDTO;
import com.example.busorder.models.entities.Booking;
import org.springframework.stereotype.Service;

@Service
public class BookingImpl implements BookingService {
    @Override
    public Booking saveBooking(BookingRequestDTO bookingRequestDTO) {

         Booking response = Booking.builder()
                .date(bookingRequestDTO.getDate())
                .departureCity(bookingRequestDTO.getDepartureCity())
                .destinationCity(bookingRequestDTO.getDestinationCity())
                .numberPeople(bookingRequestDTO.getNumberPeople())
                .id(11)
                .build();

        return response;
    }
}
