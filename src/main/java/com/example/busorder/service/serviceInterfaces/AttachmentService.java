package com.example.busorder.service.serviceInterfaces;

import com.example.busorder.models.StorageRequest;
import com.example.busorder.models.dto.NewAttachmentDTO;
import com.example.busorder.models.dto.PresignedResponseDTO;
import com.example.busorder.models.entities.Attachment;
import java.util.UUID;
import org.springframework.lang.NonNull;

public interface AttachmentService {
    PresignedResponseDTO startUpload(@NonNull UUID userId, Attachment attachment);

    void finishUpload(@NonNull UUID userId, @NonNull UUID attachmentId);
}
