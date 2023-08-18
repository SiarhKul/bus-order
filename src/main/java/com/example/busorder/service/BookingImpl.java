package com.example.busorder.service;

import com.example.busorder.models.dto.BookingRequestDTO;
import com.example.busorder.models.entities.Booking;
import com.example.busorder.models.entities.Client;
import com.example.busorder.repository.BookingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@AllArgsConstructor
public class BookingImpl implements BookingService {

    private final BookingRepository bookingRepository;

    @Override
    public Booking saveBooking(BookingRequestDTO bookingRequestDTO) {


        Client client = Client.builder()
                .id(1)
                .name("Bon")
                .surname("Bobson")
                .mobilePhone(123456789)
                .email("email@gmail.com")
                .build();

        //todo create mapper
        //todo save booking
        Booking response = Booking.builder()
                .client(client)
                .status("START")
                .date(bookingRequestDTO.getDate())
                .departureCity(bookingRequestDTO.getDepartureCity())
                .destinationCity(bookingRequestDTO.getDestinationCity())
                .numberPeople(bookingRequestDTO.getNumberPeople())
                .build();

        return bookingRepository.save(response);

//        return response;
    }
}
