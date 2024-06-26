package com.example.busorder.service;

import com.example.busorder.enums.AttachmentStatus;
import com.example.busorder.models.StorageRequest;
import com.example.busorder.models.dto.DeleteAttachmentResponseDTO;
import com.example.busorder.models.dto.NewAttachmentDTO;
import com.example.busorder.models.dto.PresignedResponseDTO;
import com.example.busorder.models.entities.Attachment;
import com.example.busorder.repository.AttachmentRepository;
import com.example.busorder.service.serviceInterfaces.AttachmentService;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Consumer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.DeleteObjectResponse;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.model.PresignedPutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.model.PutObjectPresignRequest;

@Service
@Slf4j
@RequiredArgsConstructor
public class AttachmentServiceImp implements AttachmentService {

    private final S3Presigner s3Presigner;
    private final S3Client s3Client;
    private final AttachmentRepository attachmentRepository;

    @Value("${aws.s3.bucket.attachments}")
    private String attachmentsBucket;
    @Value("${aws.s3.presigned-url.expiration.seconds}")
    private Long presignedUrlTtlSeconds;

    @Override
    public PresignedResponseDTO startUpload(UUID userId, Attachment attachment) {
        attachment.setUserId(userId);
        attachment.setUploadedTimestamp(LocalDateTime.now());
        attachment.setStatus(AttachmentStatus.PENDING);

        Attachment savedAttachment = attachmentRepository.save(attachment);

        Consumer<PutObjectRequest.Builder> putRequestBuilder = requestBuilder -> requestBuilder
                .key(getObjectKey(savedAttachment))
                .contentType(savedAttachment.getType())
                .bucket(attachmentsBucket);

        PutObjectPresignRequest presignRequest = PutObjectPresignRequest.builder()
                .putObjectRequest(putRequestBuilder)
                .signatureDuration(signatureDuration())
                .build();

        PresignedPutObjectRequest presignedRequest = s3Presigner.presignPutObject(presignRequest);

        return new PresignedResponseDTO(
                savedAttachment.getId(),
                presignedRequest.url(),
                presignedRequest.httpRequest().method().name()
        );
    }

    @Override
    public Attachment finishUpload(UUID userId, UUID attachmentId) {
        return attachmentRepository.findByUserIdAndId(userId, attachmentId)
                .map(attachment -> {
                    attachment.setStatus(AttachmentStatus.UPLOADED);
                    return attachmentRepository.save(attachment);
                })
                .orElse(null);
    }

    @Override
    public List<Attachment> getAttachments(UUID userId) {
        return attachmentRepository.findByUserId(userId);
    }

    @Override
    public DeleteAttachmentResponseDTO deleteAttachment(UUID userId, UUID attachmentId) {
        Attachment attachment = attachmentRepository.findByUserIdAndId(userId, attachmentId).orElseThrow(
                () -> new IllegalArgumentException("Attachment not found")
        );
        attachmentRepository.delete(attachment);
        return deleteAttachmentS3Bucket(getObjectKey(attachment));
    }

    private DeleteAttachmentResponseDTO deleteAttachmentS3Bucket(String objectKey) {
        DeleteObjectRequest deleteRequest = DeleteObjectRequest.builder()
                .bucket(attachmentsBucket)
                .key(objectKey)
                .build();
        log.info("Deleting object with key: {}", objectKey);
        DeleteObjectResponse deleteObjectResponse = s3Client.deleteObject(deleteRequest);
        log.info("Object deleted: {}", deleteObjectResponse);

        return DeleteAttachmentResponseDTO.builder()
                .deletedTimestamp(LocalDateTime.now())
                .deleteMarker(true)
                .build();
    }

    private String getObjectKey(Attachment newAttachmentDTO) {
        return Objects.requireNonNull(newAttachmentDTO.getUserId())
                + "/"
                + Objects.requireNonNull(newAttachmentDTO.getId());
    }

    private Duration signatureDuration() {
        return Duration.of(presignedUrlTtlSeconds, ChronoUnit.SECONDS);
    }
}
