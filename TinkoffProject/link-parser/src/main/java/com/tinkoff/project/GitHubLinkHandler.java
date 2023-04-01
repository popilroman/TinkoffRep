package com.tinkoff.project;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

final public class GitHubLinkHandler implements LinkHandler {
    private static final Pattern GITHUB_PATTERN = Pattern.compile("https://github\\.com/([\\w-]+)/([\\w-]+)/?");

    @Override
    public String handleLink(String link) {
        Matcher matcher = GITHUB_PATTERN.matcher(link);
        if (matcher.matches()) {
            return matcher.group(1) + "/" + matcher.group(2);
        }
        return null;
    }
}
