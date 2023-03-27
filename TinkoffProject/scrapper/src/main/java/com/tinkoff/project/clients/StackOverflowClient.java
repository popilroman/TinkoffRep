package com.tinkoff.project.clients;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public interface StackOverflowClient {
    Mono<String> getQuestionInfo(long questionId);
}