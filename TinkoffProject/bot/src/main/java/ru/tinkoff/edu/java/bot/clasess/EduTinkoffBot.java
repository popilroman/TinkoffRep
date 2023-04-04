package ru.tinkoff.edu.java.bot.clasess;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.BotCommand;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.SetMyCommands;

import java.util.List;

public class EduTinkoffBot {
    TelegramBot bot = new TelegramBot("6110997946:AAFvWI6CF9PSoIwWCrLIo3mmbIWiQK0x6Uk");

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
