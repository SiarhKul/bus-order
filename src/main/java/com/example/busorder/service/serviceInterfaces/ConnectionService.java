package com.example.busorder.service.serviceInterfaces;

import com.example.busorder.models.dto.ConnectionResponseDTO;
import com.example.busorder.models.dto.TripDTO;

import java.util.List;

public interface ConnectionService {
    ConnectionResponseDTO getConnection(TripDTO tripDTO);
}
