package com.example.busorder.mapper;

import com.example.busorder.enums.BookingStatus;
import com.example.busorder.models.dto.BookingRequestDTO;
import com.example.busorder.models.dto.BookingResponseDTO;
import com.example.busorder.models.entities.Booking;
import com.example.busorder.models.entities.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        imports = {BookingStatus.class})
public interface BookingMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", expression = "java(BookingStatus.FUTURE)")
    @Mapping(target = "client", expression = "java(createDefaultClient())")
    Booking toBooking(BookingRequestDTO bookingRequestDTO);

    BookingResponseDTO toBookingResponseDTO(Booking booking);

    default Client createDefaultClient() {
        Client client = Client.builder()
                .id(1)
                .name("Bon")
                .surname("Bob")
                .mobilePhone(123456789)
                .email("email@gmail.com")
                .build();
        return client;
    }


}

