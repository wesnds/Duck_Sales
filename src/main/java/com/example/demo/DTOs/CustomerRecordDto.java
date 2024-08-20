package com.example.demo.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CustomerRecordDto(
        @NotBlank String name,
        @NotNull boolean eligibleForDiscount
) {
}
