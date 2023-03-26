package com.tinkoff.project;

import com.tinkoff.project.dto.BotRequest;
import com.tinkoff.project.dto.BotResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bot")
public class BotController {

    @PostMapping("/process")
    public BotResponse process(@RequestBody BotRequest request) {
        return new BotResponse("Stubbed response for " + request.getMessage());
    }
}