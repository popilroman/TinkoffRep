package ru.tinkoff.edu.java.scrapper.storages;

import ru.tinkoff.edu.java.scrapper.objects.Chat;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.Repository;

public interface ChatStorage extends Repository<Chat, Long> {
    Page<Chat> findAll();

}
