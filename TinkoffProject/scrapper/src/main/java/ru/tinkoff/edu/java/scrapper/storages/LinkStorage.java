package ru.tinkoff.edu.java.scrapper.storages;

import ru.tinkoff.edu.java.scrapper.objects.Link;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.Repository;

public interface LinkStorage extends Repository<Link, Long> {
    Page<Link> findAll();
}
