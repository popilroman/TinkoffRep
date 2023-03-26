package com.tinkoff.project;

import com.tinkoff.project.dto.ScrapperRequest;
import com.tinkoff.project.dto.ScrapperResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scrapper")
public class ScrapperController {

    @PostMapping("/process")
    public ScrapperResponse process(@RequestBody ScrapperRequest request) {
        return new ScrapperResponse("Stubbed response for " + request.getUrl());
    }
}
