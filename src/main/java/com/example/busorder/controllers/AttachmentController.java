package com.example.busorder.controllers;

import com.example.busorder.mapper.AttachmentMapper;
import com.example.busorder.models.StorageRequest;
import com.example.busorder.models.dto.NewAttachmentDTO;
import com.example.busorder.models.dto.PresignedResponseDTO;
import com.example.busorder.models.dto.UploadedAttachmentDTO;
import com.example.busorder.models.entities.Attachment;
import com.example.busorder.service.serviceInterfaces.AttachmentService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Attachments")
@RestController
@RequestMapping("/api/attachments")
@AllArgsConstructor
@Slf4j
public class AttachmentController {

    private final AttachmentService attachmentService;
    private final AttachmentMapper attachmentMapper;

    @PostMapping("/{userId}")
    PresignedResponseDTO startUpload(@PathVariable("userId") UUID userId,
                                     @Valid @RequestBody NewAttachmentDTO newAttachmentDTO) {
        Attachment attachment = attachmentMapper.attachmentDTOtoAttachment(newAttachmentDTO);

        PresignedResponseDTO storageRequest = attachmentService.startUpload(userId, attachment);
        return storageRequest;
    }

    @PutMapping("/{userId}/{attachmentId}")
    public UploadedAttachmentDTO finishUpload(
            @PathVariable("userId") UUID userId,
            @PathVariable("attachmentId") UUID attachmentId) {

        Attachment attachment = attachmentService.finishUpload(userId, attachmentId);

        return attachmentMapper.attachmentToUploadedAttachmentDTO(attachment);
    }

}


