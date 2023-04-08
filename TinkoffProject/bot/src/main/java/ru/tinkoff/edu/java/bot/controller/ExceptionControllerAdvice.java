package ru.tinkoff.edu.java.bot.controller;

import com.tinkoff.project.dto.NullBotDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public NullBotDTO handleValidationException(MethodArgumentNotValidException ex) {
        return new NullBotDTO("Некорректные параметры запроса", HttpStatus.BAD_REQUEST.toString(), ex.getObjectName(), ex.getLocalizedMessage(), new String[]{String.valueOf(ex.getStackTrace())});
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleException(Throwable ex) {
        return "Error occurred: " + ex.getMessage();
    }
}
