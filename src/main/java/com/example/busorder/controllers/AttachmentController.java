package com.example.busorder.controllers;

import com.example.busorder.models.dto.NewAttachmentDTO;
import com.example.busorder.service.serviceInterfaces.AttachmentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/{userId}")
    void startUpload(@PathVariable("userId") UUID userId,
                     @Valid @RequestBody NewAttachmentDTO newAttachmentDTO) {
        attachmentService.startUpload(userId, newAttachmentDTO);

    }
}
