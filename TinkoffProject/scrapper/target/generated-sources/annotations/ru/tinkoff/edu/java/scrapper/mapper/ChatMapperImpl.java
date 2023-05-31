package ru.tinkoff.edu.java.scrapper.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.tinkoff.edu.java.scrapper.domain.entity.Chat;
import ru.tinkoff.edu.java.scrapper.model.response.TgChatResponse;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-31T14:20:00+0500",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class ChatMapperImpl implements ChatMapper {

    @Override
    public TgChatResponse chatToTgChatResponse(Chat chat) {
        if ( chat == null ) {
            return null;
        }

        TgChatResponse.TgChatResponseBuilder tgChatResponse = TgChatResponse.builder();

        tgChatResponse.tgChatId( chat.getTgChatId() );

        return tgChatResponse.build();
    }

    @Override
    public List<TgChatResponse> chatListToTgChatResponseList(List<Chat> chatList) {
        if ( chatList == null ) {
            return null;
        }

        List<TgChatResponse> list = new ArrayList<TgChatResponse>( chatList.size() );
        for ( Chat chat : chatList ) {
            list.add( chatToTgChatResponse( chat ) );
        }

        return list;
    }
}
