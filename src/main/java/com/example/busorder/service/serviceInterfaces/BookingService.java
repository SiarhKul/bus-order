package com.example.busorder.service.serviceInterfaces;

import com.example.busorder.models.dto.BookingRequestDTO;
import com.example.busorder.models.dto.BookingResponseDTO;
import com.example.busorder.models.entities.Booking;

public interface BookingService {

    BookingResponseDTO saveBooking(BookingRequestDTO requestDTO);

}
