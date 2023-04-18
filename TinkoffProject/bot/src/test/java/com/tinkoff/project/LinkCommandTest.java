package com.tinkoff.project;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.tinkoff.edu.java.bot.clasess.EduTinkoffBotCommands;

public class LinkCommandTest
{
    EduTinkoffBotCommands eduTinkoffBotCommands;
    @Before
    public void setBot(){
        eduTinkoffBotCommands = new EduTinkoffBotCommands();
    }
    @Test
    public void ListExistsResponseTest(){
        eduTinkoffBotCommands.setHasList(true);
        Assert.assertEquals("Список ссылок",eduTinkoffBotCommands.getResponse("/list"));
    }
    @Test
    public void ListNotExistsResponseTest(){
        eduTinkoffBotCommands.setHasList(false);
        Assert.assertEquals("Нет списка ссылок",eduTinkoffBotCommands.getResponse("/list"));
    }
}
