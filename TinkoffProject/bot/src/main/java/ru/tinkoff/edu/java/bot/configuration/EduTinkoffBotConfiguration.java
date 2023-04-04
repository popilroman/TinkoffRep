package ru.tinkoff.edu.java.bot.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.tinkoff.edu.java.bot.clasess.EduTinkoffBot;

@Configuration
public class EduTinkoffBotConfiguration {
    @Bean("tg_bot_starter")
    public EduTinkoffBot startBot(){
        EduTinkoffBot eduTinkoffBot = new EduTinkoffBot();
        eduTinkoffBot .startBot();
        return eduTinkoffBot ;
    }
}
