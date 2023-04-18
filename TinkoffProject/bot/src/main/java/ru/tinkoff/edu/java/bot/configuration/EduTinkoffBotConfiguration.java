package ru.tinkoff.edu.java.bot.configuration;

import org.springframework.context.annotation.Configuration;
import ru.tinkoff.edu.java.bot.clasess.EduTinkoffBot;

@Configuration
public class EduTinkoffBotConfiguration {
    public EduTinkoffBot startBot(EduTinkoffBot eduTinkoffBot){
        return eduTinkoffBot;
    }
}
