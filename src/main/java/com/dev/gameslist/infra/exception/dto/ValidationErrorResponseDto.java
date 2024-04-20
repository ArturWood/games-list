package com.dev.gameslist.infra.exception.dto;

import org.springframework.validation.FieldError;

public record ValidationErrorResponseDto(
        String field,
        String message
) {
    public ValidationErrorResponseDto(FieldError error) {
        this(error.getField(), error.getDefaultMessage());
    }
}
