package com.example.busorder.models.dto;

import java.net.URL;
import java.util.UUID;

public record PresignedResponseDTO(UUID id, URL url, String method) {
}
