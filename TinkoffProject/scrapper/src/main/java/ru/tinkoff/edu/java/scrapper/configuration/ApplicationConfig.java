package ru.tinkoff.edu.java.scrapper.configuration;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;
import org.springframework.validation.annotation.Validated;
import reactor.core.scheduler.Scheduler;

import java.time.Duration;

@ConfigurationProperties(prefix = "app")
public class ApplicationConfig {
    private String test;
    private Duration schedulerInterval;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public Duration getSchedulerInterval() {
        return schedulerInterval;
    }

    public void setSchedulerInterval(Duration schedulerInterval) {
        this.schedulerInterval = schedulerInterval;
    }
}


