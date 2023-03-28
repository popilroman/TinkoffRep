package com.tinkoff.project.dto;

import jakarta.validation.constraints.NotNull;



public record ApiErrorResponse(@NotNull String description,
                               @NotNull String code,
                               @NotNull String exceptionName,
                               @NotNull String exceptionMessage,
                               @NotNull String[] stacktrace) {
}
