package ru.tinkoff.edu.java.bot.clasess;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.BotCommand;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.SetMyCommands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.tinkoff.edu.java.bot.configuration.ApplicationConfig;

import java.util.List;
@Component
public class EduTinkoffBot {
//    TelegramBot bot = new TelegramBot("6110997946:AAFvWI6CF9PSoIwWCrLIo3mmbIWiQK0x6Uk");
    private final TelegramBot bot;
    private final ApplicationConfig applicationConfig;

    @Autowired
    public EduTinkoffBot(ApplicationConfig applicationConfig) {
        this.applicationConfig = applicationConfig;
        bot = new TelegramBot(applicationConfig.getToken());
    }

    public void startBot() {
        EduTinkoffBotCommands eduTinkoffBotCommands = new EduTinkoffBotCommands();
        eduTinkoffBotCommands.setBot(bot);
        eduTinkoffBotCommands.setUpdateListener();

        BotCommand[] botCommands = {
                new BotCommand("start", "зарегистрировать пользователя"),
                new BotCommand("help", "вывести окно с командами"),
                new BotCommand("track", "начать отслеживание ссылки"),
                new BotCommand("untrack", "прекратить отслеживание ссылки"),
                new BotCommand("list", "показать список отслеживаемых ссылок")};
        bot.execute(new SetMyCommands(botCommands));
    }
}
