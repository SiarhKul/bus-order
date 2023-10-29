package com.example.busorder.service;

import com.example.busorder.mapper.BookingMapper;
import com.example.busorder.models.dto.BookingRequestDTO;
import com.example.busorder.models.dto.BookingResponseDTO;
import com.example.busorder.models.entities.Booking;
import com.example.busorder.models.entities.Client;
import com.example.busorder.repository.BookingRepository;
import com.example.busorder.service.serviceInterfaces.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookingImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;


    @Override
    public BookingResponseDTO saveBooking(BookingRequestDTO bookingRequestDTO) {

        Booking booking = bookingMapper.toBooking(bookingRequestDTO);

        Booking returnedBooking = bookingRepository.save(booking);

        return bookingMapper.toBookingResponseDTO(returnedBooking);
    }
}
