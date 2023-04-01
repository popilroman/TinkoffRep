package com.tinkoff.project;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

final public class StackoverflowLinkHandler implements LinkHandler
{
    private static final Pattern STACKOVERFLOW_PATTERN = Pattern.compile("https://stackoverflow.com/questions/(\\d+)/.*");

    @Override
    public String handleLink(String link)
    {
        Matcher matcher = STACKOVERFLOW_PATTERN.matcher(link);
        if (matcher.matches())
        {
            return matcher.group(1);
        }
        return null;
    }
}
