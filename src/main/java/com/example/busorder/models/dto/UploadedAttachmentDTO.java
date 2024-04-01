package com.example.busorder.models.dto;

import com.example.busorder.enums.AttachmentStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class UploadedAttachmentDTO {

    private UUID id;

    private UUID userId;

    private String fileName;

    private String type;

    private Long size;

    private LocalDateTime uploadedTimestamp;

    private AttachmentStatus status;
}
