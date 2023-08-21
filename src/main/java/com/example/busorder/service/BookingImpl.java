package com.example.busorder.service;

import com.example.busorder.models.dto.BookingRequestDTO;
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

    @Override
    public Booking saveBooking(BookingRequestDTO bookingRequestDTO) {


        Client client = Client.builder()
                .id(1)
                .name("Bon")
                .surname("Bobson")
                .mobilePhone(123456789)
                .email("email@gmail.com")
                .build();


//SELECT * from schedule where (date='2023-08-10' and time > cast(now() as time))
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
