package com.example.busorder.mapper;

import com.example.busorder.models.dto.NewAttachmentDTO;
import com.example.busorder.models.entities.Attachment;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AttachmentMapper {
    Attachment attachmentDTOtoAttachment(NewAttachmentDTO newAttachmentDTO);
}