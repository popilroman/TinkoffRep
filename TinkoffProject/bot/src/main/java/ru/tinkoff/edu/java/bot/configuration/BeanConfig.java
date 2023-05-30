package ru.tinkoff.edu.java.bot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;

@Configuration
public class BeanConfig {
    @Bean
    public TelegramConfig telegramConfig(ApplicationConfig config) {
        return config.bot();
    }
    @Bean
    public MeterRegistry meterRegistry()
    {
        return new SimpleMeterRegistry();
    }
    @Bean
    public Counter botMessageCounter(MeterRegistry meterRegistry)
    {
        return Counter.builder("botMessageCounter")
                .register(meterRegistry);
    }
}
