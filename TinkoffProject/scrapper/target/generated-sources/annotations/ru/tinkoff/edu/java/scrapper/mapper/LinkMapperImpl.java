package ru.tinkoff.edu.java.scrapper.mapper;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.tinkoff.edu.java.scrapper.domain.entity.Link;
import ru.tinkoff.edu.java.scrapper.model.dto.LinkResponseDto;
import ru.tinkoff.edu.java.scrapper.model.request.AddLinkRequest;
import ru.tinkoff.edu.java.scrapper.model.response.LinkResponse;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-26T10:16:55+0500",
    comments = "version: 1.5.4.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class LinkMapperImpl implements LinkMapper {

    @Override
    public Link addLinkRequestToLink(AddLinkRequest addLinkRequest) {
        if ( addLinkRequest == null ) {
            return null;
        }

        Link.LinkBuilder link = Link.builder();

        link.type( addLinkRequest.getType() );

        link.url( addLinkRequest.getLink().toString() );

        return link.build();
    }

    @Override
    public LinkResponse linkToLinkResponse(Link link) {
        if ( link == null ) {
            return null;
        }

        LinkResponse.LinkResponseBuilder linkResponse = LinkResponse.builder();

        linkResponse.id( link.getId() );

        linkResponse.url( URI.create(link.getUrl()) );

        return linkResponse.build();
    }

    @Override
    public LinkResponseDto linkToLinkResponseDto(Link link) {
        if ( link == null ) {
            return null;
        }

        LinkResponseDto.LinkResponseDtoBuilder linkResponseDto = LinkResponseDto.builder();

        linkResponseDto.id( link.getId() );
        linkResponseDto.type( link.getType() );
        linkResponseDto.lastUpdate( link.getLastUpdate() );
        linkResponseDto.lastCheck( link.getLastCheck() );

        linkResponseDto.url( URI.create(link.getUrl()) );

        return linkResponseDto.build();
    }

    @Override
    public List<LinkResponse> linkListToLinkResponseList(List<Link> links) {
        if ( links == null ) {
            return null;
        }

        List<LinkResponse> list = new ArrayList<LinkResponse>( links.size() );
        for ( Link link : links ) {
            list.add( linkToLinkResponse( link ) );
        }

        return list;
    }

    @Override
    public List<LinkResponseDto> linkListToLinkResponseDtoList(List<Link> links) {
        if ( links == null ) {
            return null;
        }

        List<LinkResponseDto> list = new ArrayList<LinkResponseDto>( links.size() );
        for ( Link link : links ) {
            list.add( linkToLinkResponseDto( link ) );
        }

        return list;
    }
}
