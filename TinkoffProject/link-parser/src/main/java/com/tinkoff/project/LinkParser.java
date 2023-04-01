package com.tinkoff.project;

import java.util.List;

public class LinkParser
{
    private static final List<LinkHandler> HANDLERS = List.of(new GitHubLinkHandler(), new StackoverflowLinkHandler());

    public static String parseLink(String link)
    {
        for (LinkHandler handler : HANDLERS)
        {
            String result = handler.handleLink(link);
            if (result != null)
            {
                return result;
            }
        }
        return null;
    }
}
