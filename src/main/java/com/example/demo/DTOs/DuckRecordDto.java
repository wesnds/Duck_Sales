package com.example.demo.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DuckRecordDto(
        @NotBlank String name,
        @NotNull Long parentId
) {
}
