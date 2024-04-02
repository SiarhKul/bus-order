package com.example.busorder.repository;

import com.example.busorder.models.entities.Attachment;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepository extends JpaRepository<Attachment, UUID> {
    Optional<Attachment> findByUserIdAndId(UUID userId, UUID attachmentId);

    List<Attachment> findByUserId(UUID userId);
}
