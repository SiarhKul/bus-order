package com.example.busorder.service;

import com.example.busorder.models.StorageRequest;
import com.example.busorder.models.dto.NewAttachmentDTO;
import com.example.busorder.models.entities.Attachment;
import com.example.busorder.repository.AttachmentRepository;
import com.example.busorder.service.serviceInterfaces.AttachmentService;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Consumer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.s3.S3Client;
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
    public StorageRequest startUpload(UUID userId, Attachment attachment) {
        attachment.setUserId(userId);
        attachment.setUploadedTimestamp(LocalDateTime.now());

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

        return new StorageRequest(
                presignedRequest.url(),
                presignedRequest.httpRequest().method().name());

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
