package com.example.busorder.service.serviceInterfaces;

import com.example.busorder.models.StorageRequest;
import com.example.busorder.models.dto.NewAttachmentDTO;
import com.example.busorder.models.dto.PresignedResponseDTO;
import com.example.busorder.models.entities.Attachment;
import java.util.List;
import java.util.UUID;
import org.springframework.lang.NonNull;

public interface AttachmentService {
    PresignedResponseDTO startUpload(@NonNull UUID userId, Attachment attachment);

    Attachment finishUpload(@NonNull UUID userId, @NonNull UUID attachmentId);

    List<Attachment> getAttachments(@NonNull UUID userId);

    void deleteAttachment(UUID userId, UUID attachmentId);
}
