package com.example.busorder.mapper;

import com.example.busorder.models.dto.BookingRequestDTO;
import com.example.busorder.models.entities.Booking;
import com.example.busorder.models.entities.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface BookingMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", constant = "START")
    @Mapping(target = "client", expression = "java(createDefaultClient())")
    Booking toBooking(BookingRequestDTO bookingRequestDTO);

    default Client createDefaultClient() {
        Client client = Client.builder()
                .id(1)
                .name("Bon")
                .surname("Bobson")
                .mobilePhone(123456789)
                .email("email@gmail.com")
                .build();
        return client;
    }

}

