package com.example.busorder.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewAttachmentDTO {

    @NotBlank
    @Size(max = 255, min = 1)
    @JsonProperty("fileName")
    private String name;

    @NotNull
    @Min(1)
    @JsonProperty("sizeBytes")
    private Long size;

    @JsonProperty("contentType")
    private String type;
}
