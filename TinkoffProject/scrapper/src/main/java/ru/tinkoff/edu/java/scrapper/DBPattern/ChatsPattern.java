package ru.tinkoff.edu.java.scrapper.DBPattern;


import ru.tinkoff.edu.java.scrapper.objects.Chat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ru.tinkoff.edu.java.scrapper.storages.ChatStorage;

@Service
public class ChatsPattern {
    @Autowired
    private ChatStorage chatStorage;
    public Page<Chat> getChats(){
        return chatStorage.findAll();
    }
}
