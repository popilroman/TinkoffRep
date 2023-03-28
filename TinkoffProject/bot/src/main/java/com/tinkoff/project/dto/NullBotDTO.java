package com.tinkoff.project.dto;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Validated
@Data
public class NullBotDTO {
    public NullBotDTO(String description,String code,String exceptionName,String exceptionMessage,String[] stacktrace) {
        this.description = description;
        this.code = code;
        this.exceptionName = exceptionName;
        this.exceptionMessage = exceptionMessage;
        this.stacktrace = stacktrace;
    }
    private String exceptionName;
    private String description;
    private String code;
    private String exceptionMessage;
    private String[] stacktrace;
}

