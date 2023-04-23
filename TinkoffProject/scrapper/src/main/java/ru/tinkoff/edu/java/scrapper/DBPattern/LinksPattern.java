package ru.tinkoff.edu.java.scrapper.DBPattern;


import ru.tinkoff.edu.java.scrapper.objects.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ru.tinkoff.edu.java.scrapper.storages.LinkStorage;

@Service
public class LinksPattern {
    @Autowired
    private LinkStorage linkStorage;
    public Page<Link> getLinks(){
        return linkStorage.findAll();
    }
}
