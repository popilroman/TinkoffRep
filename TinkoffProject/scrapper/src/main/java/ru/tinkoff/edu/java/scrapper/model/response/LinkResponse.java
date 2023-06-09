package ru.tinkoff.edu.java.scrapper.model.response;

import lombok.*;

import java.net.URI;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class LinkResponse {
    private Long id;
    private URI url;
}
