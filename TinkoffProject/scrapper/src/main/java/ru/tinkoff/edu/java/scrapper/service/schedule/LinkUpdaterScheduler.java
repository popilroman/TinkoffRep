package ru.tinkoff.edu.java.scrapper.service.schedule;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.tinkoff.edu.java.parser.Parser;
import ru.tinkoff.edu.java.parser.result.GitHubResultRecord;
import ru.tinkoff.edu.java.parser.result.ParseResult;
import ru.tinkoff.edu.java.parser.result.StackOverflowResultRecord;
import ru.tinkoff.edu.java.scrapper.dto.LinkResponseDto;
import ru.tinkoff.edu.java.scrapper.dto.UpdatesDto;
import ru.tinkoff.edu.java.scrapper.dto.updates.GitHubUpdatesDto;
import ru.tinkoff.edu.java.scrapper.dto.updates.StackOverflowUpdatesDto;
import ru.tinkoff.edu.java.scrapper.model.request.LinkUpdateRequest;
import ru.tinkoff.edu.java.scrapper.model.response.GitHubRepositoryInfoResponse;
import ru.tinkoff.edu.java.scrapper.model.response.StackOverflowQuestionInfoResponse;
import ru.tinkoff.edu.java.scrapper.service.LinkService;
import ru.tinkoff.edu.java.scrapper.service.LinkUpdater;
import ru.tinkoff.edu.java.scrapper.service.client.BotClient;
import ru.tinkoff.edu.java.scrapper.service.client.GitHubClient;
import ru.tinkoff.edu.java.scrapper.service.client.StackOverflowClient;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
@RequiredArgsConstructor
public class LinkUpdaterScheduler implements LinkUpdater {
    private final LinkService linkService;
    private final GitHubClient gitHubClient;
    private final StackOverflowClient stackOverflowClient;
    private final BotClient botClient;
    private final Parser parser;

    @Override
    @Scheduled(fixedDelayString = "#{@schedulingIntervalMillis}")
    public void update() {
        List<LinkResponseDto> allOldestLinksByLastUpdate = linkService.findAllOldestLinksByLastCheck();

        getUpdatesForGitHubLinks(allOldestLinksByLastUpdate);
        getUpdatesForStackOverflowLinks(allOldestLinksByLastUpdate);
    }

    private void getUpdatesForGitHubLinks(List<LinkResponseDto> allOldestLinksByLastUpdate) {
        allOldestLinksByLastUpdate
                .stream()
                .filter(it -> it.getType()
                        .equals("github"))
                .forEach(it -> {
                    ParseResult parseResult = parser.checkLink(it.getUrl()
                            .toString());
                    GitHubRepositoryInfoResponse response = gitHubClient
                            .getGitHubRepositoryInfo((GitHubResultRecord) parseResult)
                            .block();
                    if (response != null && response.getUpdatedAt()
                            .isAfter(it.getLastUpdate())) {
                        GitHubUpdatesDto updates = (GitHubUpdatesDto) linkService
                                .findUpdatesByLinkIdAndLinkType(it.getId(), it.getType());
                        Map<String, String> gitHubChanges = getGitHubChanges(updates, response);
                        linkService.setGitHubLastUpdate(it.getId(), response);
                        ResponseEntity<Void> messageForBot = sendRequestToBot(it, gitHubChanges);

                        log.info("Get update for: id=" + it.getId() + " --- " + it.getUrl() + " --- " + gitHubChanges +
                                " --- bot answer: " + (messageForBot != null ? messageForBot.getStatusCode() : "null"));
                    } else {
                        linkService.setLastCheck(it.getId());
                    }
                });
    }

    private void getUpdatesForStackOverflowLinks(List<LinkResponseDto> allOldestLinksByLastUpdate) {
        allOldestLinksByLastUpdate
                .stream()
                .filter(it -> it.getType()
                        .equals("stack"))
                .forEach(it -> {
                    ParseResult parseResult = parser.checkLink(it.getUrl()
                            .toString());
                    StackOverflowQuestionInfoResponse response = stackOverflowClient
                            .getStackOverflowQuestionInfo((StackOverflowResultRecord) parseResult)
                            .block();
                    if (response != null) {
                        OffsetDateTime responseLastUpdate =
                                response.getItems()
                                        .stream()
                                        .map(StackOverflowQuestionInfoResponse.Items::getLastActivityDate)
                                        .findFirst()
                                        .orElse(it.getLastUpdate());
                        if (responseLastUpdate.isAfter(it.getLastUpdate())) {
                            StackOverflowUpdatesDto updates = (StackOverflowUpdatesDto) linkService
                                    .findUpdatesByLinkIdAndLinkType(it.getId(), it.getType());
                            Map<String, String> stackChanges = getStackOverflowChanges(updates, response);
                            linkService.setStackOverflowLastUpdate(it.getId(), response);
                            ResponseEntity<Void> messageForBot = sendRequestToBot(it, stackChanges);

                            log.info("Get update for: id=" + it.getId() + " --- " + it.getUrl() + " --- " + stackChanges +
                                    " --- bot answer: " + (messageForBot != null ? messageForBot.getStatusCode() : "null"));
                        } else {
                            linkService.setLastCheck(it.getId());
                        }
                    }
                });
    }

    @Nullable
    private ResponseEntity<Void> sendRequestToBot(LinkResponseDto it, Map<String, String> changes) {
        return botClient.postLinks(LinkUpdateRequest.builder()
                        .tgChat(it.getId())
                        .description("Update available")
                        .url(it.getUrl()
                                .toString())
                        .changes(changes)
                        .build())
                .block();
    }

    private Map<String, String> getGitHubChanges(GitHubUpdatesDto updates,
                                                 GitHubRepositoryInfoResponse response) {
        Map<String, String> changes = new HashMap<>();
        if (response.getWatchers() > updates.getWatchers()) {
            changes.put("watchers", "+" + (response.getWatchers() - updates.getWatchers()));
        }
        if (response.getForksCount() > updates.getForksCount()) {
            changes.put("fork_count", "+" + (response.getForksCount() - updates.getForksCount()));
        }
        return changes;
    }

    private Map<String, String> getStackOverflowChanges(StackOverflowUpdatesDto updates,
                                                        StackOverflowQuestionInfoResponse response) {
        Integer answerCount = response.getItems()
                .stream()
                .map(StackOverflowQuestionInfoResponse.Items::getAnswerCount)
                .findFirst()
                .orElse(-1);

        Boolean isAnswered = response.getItems()
                .stream()
                .map(StackOverflowQuestionInfoResponse.Items::isAnswered)
                .findFirst()
                .orElse(false);

        Map<String, String> changes = new HashMap<>();
        if (answerCount > updates.getAnswerCount()) {
            changes.put("answer_count", "+" + (answerCount - updates.getAnswerCount()));
        }
        if (isAnswered != updates.isAnswered()) {
            changes.put("is_answered", isAnswered.toString());
        }
        return changes;
    }
}