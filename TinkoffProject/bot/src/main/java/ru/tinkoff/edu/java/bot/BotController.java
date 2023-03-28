package ru.tinkoff.edu.java.bot;

import com.tinkoff.project.dto.*;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/updates")
public class BotController {

    @PostMapping(consumes = "application/json", produces = "application/json")
    public BotDTO update(@Valid @RequestBody BotDTO dataClass) {
        return new BotDTO(dataClass.getId(), dataClass.getUrl(), dataClass.getDescription(), dataClass.getTgChatIds());
    }


    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public NullBotDTO handleException(MethodArgumentNotValidException e){
        return new NullBotDTO("Некорректные параметры запроса", e.getStatusCode().toString(), e.getObjectName(), e.getLocalizedMessage(), new String[]{String.valueOf(e.getStackTrace())});
    }

}