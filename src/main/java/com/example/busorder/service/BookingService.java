package com.example.busorder.service;

import com.example.busorder.models.dto.BookingRequestDTO;
import com.example.busorder.models.entities.Booking;

public interface BookingService {

   Booking saveBooking(BookingRequestDTO requestDTO);

}
