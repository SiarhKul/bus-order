package com.example.busorder.service.serviceInterfaces;

import com.example.busorder.models.dto.NewAttachmentDTO;
import java.util.UUID;
import org.springframework.lang.NonNull;

public interface AttachmentService {
    void startUpload(@NonNull UUID contractId, NewAttachmentDTO newAttachmentDTO);
}
