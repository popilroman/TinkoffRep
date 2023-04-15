package ru.tinkoff.edu.java.scrapper.controller;

import ru.tinkoff.edu.java.scrapper.DBPattern.*;
import ru.tinkoff.edu.java.scrapper.objects.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scrapper")
public class ScrapperDataBaseController {
    @Autowired
    ChatsPattern chatsPattern;
    @Autowired
    LinksPattern linksPattern;
    @GetMapping("/chats")
    @ResponseBody
    public Page<Chat> chats(){
        return chatsPattern.getChats();
    }
    @GetMapping("/links")
    @ResponseBody
    public Page<Link> links(){
        return linksPattern.getLinks();
    }

}
