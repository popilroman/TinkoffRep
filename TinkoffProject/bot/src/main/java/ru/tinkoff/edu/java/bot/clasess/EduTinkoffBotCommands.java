package ru.tinkoff.edu.java.bot.clasess;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;

import java.util.List;

public class EduTinkoffBotCommands {
    private TelegramBot bot;
    private boolean hasList = true;
    public void setUpdateListener(){
        this.bot.setUpdatesListener(new UpdatesListener() {
            @Override
            public int process(List<Update> updates) {
                updates.forEach(update ->{
                            if (update.message()==null){
                                return;
                            }
                            String msg = update.message().text();
                            System.out.println(msg);
                            doAction(msg, update);
                        }
                );
                return UpdatesListener.CONFIRMED_UPDATES_ALL;
            }
        });
    }
    public void setBot(TelegramBot bot){
        this.bot = bot;
    }
    private void doAction(String message, Update update){
        bot.execute(new SendMessage(update.message().chat().id(), getResponse(message)));
    }
    public String getResponse(String  message){
        String helpMessage = "/help - вывести окно с командами\n" +
                "/track - начать отслеживание ссылки\n" +
                "/untrack - прекратить отслеживание ссылки\n" +
                "/list - показать список отслеживаемых ссылок";
        String startMessage = "Приветствую! Я бот разработаный на курсе от Тинькофф. Для получения списка доступных команд напишите /help.";
        String unknownMessage = "Вы ввели неизвестную комманду. Для отображения доступных команд, воспользуйтесь /help";
        switch (message){
            case "/help": return helpMessage ;
            case "/start": return startMessage;
            case "/track": return  "Отслеживать ссылку";
            case "/untrack": return "Не отслеживать ссылку";
            case "/list": return  (hasList)?"Список ссылок":"Нет списка ссылок";
            default: return  unknownMessage;
        }
    }
    public void setHasList(boolean inHasList){
        this.hasList = inHasList;
    }
}