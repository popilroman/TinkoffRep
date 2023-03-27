package com.tinkoff.project.controller;

import com.tinkoff.project.dto.BotRequest;
import com.tinkoff.project.dto.BotResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/bot/process", method = RequestMethod.GET)
public class BotController {
    @GetMapping
    public BotResponse process(@RequestParam(name = "message", required = false, defaultValue = "default message") String message) {
        return new BotResponse("Stubbed response for " + message);
    }
}

    /*В данном случае мы указали, что параметр message является необязательным (required=false)
     и имеет дефолтное значение, равное "default message" (defaultValue="default message").
     Если параметр будет присутствовать в запросе, то его значение будет передано в метод контроллера;
     если параметр отсутствует, то будет использовано дефолтное значение.*/