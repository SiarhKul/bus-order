package com.example.busorder.models.entities;

import com.example.busorder.enums.AttachmentStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "attachment")
public class Attachment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @Column(name = "file_name", nullable = false)
    private String fileName;

    @Column(name = "type")
    private String type;

    @Column(name = "size", nullable = false)
    private Long size;

    @Column(name = "uploaded_timestamp", nullable = false)
    private LocalDateTime uploadedTimestamp;

//    @Column(name = "uploaded_by", nullable = false)
//    private UUID uploadedBy;

    @Column(name = "status", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private AttachmentStatus status;
}
