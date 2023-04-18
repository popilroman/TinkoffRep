package ru.tinkoff.edu.java.bot.configuration;

import jakarta.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Validated
@ConfigurationProperties(prefix = "app", ignoreUnknownFields = false)
public class ApplicationConfig {
    @NotNull
    private String test;

    @Value("${telegram.bot.token}")
    private String token;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public String getToken() {
        return token;
    }
}