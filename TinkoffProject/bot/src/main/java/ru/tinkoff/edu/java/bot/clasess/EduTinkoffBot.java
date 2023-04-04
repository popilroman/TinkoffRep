package ru.tinkoff.edu.java.bot.clasess;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.BotCommand;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.SetMyCommands;
import com.pengrad.telegrambot.response.SendResponse;
import org.hibernate.validator.internal.constraintvalidators.bv.time.futureorpresent.AbstractFutureOrPresentJavaTimeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.util.List;

public class EduTinkoffBot {
    TelegramBot bot = new TelegramBot("6110997946:AAFvWI6CF9PSoIwWCrLIo3mmbIWiQK0x6Uk");

    public void startBot() {
        bot.setUpdatesListener(new UpdatesListener() {
            @Override
            public int process(List<Update> updates) {
                for (Update update : updates) {
                    if (update.message() == null) {
                        continue;
                    }
                    String message = update.message().text();
                    System.out.println(message);
                    String helpMessage = "/help - вывести окно с командами\n" +
                            "/track - начать отслеживание ссылки\n" +
                            "/untrack - прекратить отслеживание ссылки\n" +
                            "/list - показать список отслеживаемых ссылок";
                    String startMessage = "Приветствую! Я бот разработаный на курсе от Тинькофф. Для получения списка доступных команд напишите /help.";
                    String unknownMessage = "Вы ввели неизвестную комманду. Для отображения доступных команд, воспользуйтесь /help";

                    switch (message) {
                        case "/help":
                            bot.execute(new SendMessage(update.message().chat().id(), helpMessage));
                            break;
                        case "/start":
                            bot.execute(new SendMessage(update.message().chat().id(), startMessage));
                            break;
                        case "/track":
                            bot.execute(new SendMessage(update.message().chat().id(), "Отслеживать ссылку"));
                            break;
                        case "/untrack":
                            bot.execute(new SendMessage(update.message().chat().id(), "Не отслеживать ссылку"));
                            break;
                        case "/list":
                            bot.execute(new SendMessage(update.message().chat().id(), "Список ссылок"));
                            break;
                        default:
                            bot.execute(new SendMessage(update.message().chat().id(), unknownMessage));
                    }
                }
                return UpdatesListener.CONFIRMED_UPDATES_ALL;
            }
        });
        BotCommand[] botCommands = {
                new BotCommand("start", "зарегистрировать пользователя"),
                new BotCommand("help", "вывести окно с командами"),
                new BotCommand("track", "начать отслеживание ссылки"),
                new BotCommand("untrack", "прекратить отслеживание ссылки"),
                new BotCommand("list", "показать список отслеживаемых ссылок")};
        bot.execute(new SetMyCommands(botCommands));
    }
}