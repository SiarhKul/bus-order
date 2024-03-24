package com.example.busorder.service;

import com.example.busorder.models.dto.NewAttachmentDTO;
import com.example.busorder.service.serviceInterfaces.AttachmentService;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AttachmentServiceImp implements AttachmentService {
    @Override
    public void startUpload(UUID userId, NewAttachmentDTO newAttachmentDTO) {
        log.info("Start upload attachment for user with newAttachmentDTO = {}", newAttachmentDTO);
    }
}
