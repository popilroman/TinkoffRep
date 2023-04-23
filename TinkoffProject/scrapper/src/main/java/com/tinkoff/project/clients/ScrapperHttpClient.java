package com.tinkoff.project.clients;

import com.tinkoff.project.dto.AddLinkRequest;
import com.tinkoff.project.dto.ApiErrorResponse;
import com.tinkoff.project.dto.LinkResponse;
import com.tinkoff.project.dto.ListLinksResponse;
import com.tinkoff.project.dto.RemoveLinkRequest;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URI;

public class ScrapperHttpClient {

    private final WebClient webClient;

    public ScrapperHttpClient(String baseUrl) {
        this.webClient = WebClient.builder().baseUrl(baseUrl).build();
    }

    public Mono<LinkResponse> addLink(URI link) {
        var addLinkRequest = new AddLinkRequest(link);
        return webClient.post()
                .uri("/links")
                .bodyValue(addLinkRequest)
                .exchangeToMono(response -> {
                    if (response.statusCode().is2xxSuccessful()) {
                        return response.bodyToMono(LinkResponse.class);
                    } else if (response.statusCode().is4xxClientError()) {
                        return response.bodyToMono(ApiErrorResponse.class)
                                .flatMap(error -> Mono.error(new ConstraintViolationException(
                                        error.description(), null)));
                    } else {
                        return Mono.error(new RuntimeException("Internal server error"));
                    }
                });
    }

    public Mono<ListLinksResponse> listLinks() {
        return webClient.get()
                .uri("/links")
                .retrieve()
                .bodyToMono(ListLinksResponse.class);
    }

    public Mono<Void> removeLink(URI link) {
        return webClient.delete()
                .uri(uriBuilder -> uriBuilder.path("/links").queryParam("link", link).build())
                .retrieve()
                .toBodilessEntity()
                .then();
    }
}