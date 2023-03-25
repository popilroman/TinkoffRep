package com.tinkoff.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tinkoff.edu.java.scrapper.configuration.ApplicationConfig;
/*import ru.tinkoff.edu.java.bot.dto.RequestMessage;
import ru.tinkoff.edu.java.bot.dto.ResponseMessage;*/

@RestController
public class ScrapperController
{
    @RequestMapping("/")
    String hello()
    {
        return "<html>" +
                "<h1>Scrapper</h1>" +
                "</html>";
    }
}
