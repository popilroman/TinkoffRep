package com.tinkoff.project.dto;

import org.springframework.validation.annotation.Validated;
import lombok.Data;


@Validated
@Data
public class BotDTO {
    public BotDTO(int id,String url,String description,int[] tgChatIds){
        this.id = id;
        this.url = url;
        this.description = description;
        this.tgChatIds = tgChatIds;
    }
    private int id;
    private String url;
    private String description;
    private int[] tgChatIds;
}
