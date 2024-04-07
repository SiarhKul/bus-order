package com.example.busorder.models.dto;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DeleteAttachmentResponseDTO {

    private Boolean deleteMarker;

     private LocalDateTime deletedTimestamp;

}
