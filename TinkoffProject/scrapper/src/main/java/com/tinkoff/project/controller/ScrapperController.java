package com.tinkoff.project.controller;

import com.tinkoff.project.dto.ScrapperRequest;
import com.tinkoff.project.dto.ScrapperResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/scrapper/process", method = RequestMethod.GET)
public class ScrapperController {

    @PostMapping
    public ScrapperResponse process(@RequestParam(name = "message", required = false, defaultValue = "default message") String message) {
        return new ScrapperResponse("Stubbed response for " + message);
    }
}
