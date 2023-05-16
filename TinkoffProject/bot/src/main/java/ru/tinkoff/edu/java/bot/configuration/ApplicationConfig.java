package ru.tinkoff.edu.java.bot.configuration;

import jakarta.validation.constraints.NotNull;
<<<<<<< HEAD

import org.springframework.beans.factory.annotation.Value;
=======
>>>>>>> hw5
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Validated
@ConfigurationProperties(prefix = "app", ignoreUnknownFields = false)
<<<<<<< HEAD
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
=======
public record ApplicationConfig(@NotNull String test, @NotNull TelegramConfig bot) {
}
>>>>>>> hw5
