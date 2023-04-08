package com.tinkoff.project.clients;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public interface GitHubClient
{
    Mono<String> getRepoInfo(String owner, String repoName);
}
