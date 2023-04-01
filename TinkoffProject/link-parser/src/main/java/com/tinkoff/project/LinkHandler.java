package com.tinkoff.project;

sealed interface LinkHandler permits GitHubLinkHandler, StackoverflowLinkHandler{
    String handleLink(String link);
}
