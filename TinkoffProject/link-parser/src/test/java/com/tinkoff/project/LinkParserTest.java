package com.tinkoff.project;

import org.junit.Test;
import org.junit.Assert;

public class LinkParserTest {

    @Test
    public void testGitHubLinkHandler() {
        LinkHandler handler = new GitHubLinkHandler();

        String validLink = "https://github.com/sanyarnd/tinkoff-java-course-2022/";
        String invalidLink = "https://github.com/sanyarnd/tinkoff-java-course-2022/issues/1234";

        String result = handler.handleLink(validLink);
        Assert.assertEquals("sanyarnd/tinkoff-java-course-2022", result);

        result = handler.handleLink(invalidLink);
        Assert.assertNull(result);
    }

    @Test
    public void testStackoverflowLinkHandler() {
        LinkHandler handler = new StackoverflowLinkHandler();

        String validLink = "https://stackoverflow.com/questions/1642028/what-is-the-operator-in-c";
        String invalidLink = "https://stackoverflow.com/users/1642028/what-is-the-operator-in-c";

        String result = handler.handleLink(validLink);
        Assert.assertEquals("1642028", result);

        result = handler.handleLink(invalidLink);
        Assert.assertNull(result);
    }

    @Test
    public void testLinkParser() {
        String githubLink = "https://github.com/popilroman/TinkoffRep";
        String stackoverflowLink = "https://stackoverflow.com/questions/654321/what-is-spring";
        String invalidLink = "https://stackoverflow.com/search?q=unsupported%20link";

        String result = LinkParser.parseLink(githubLink);
        Assert.assertEquals("popilroman/TinkoffRep", result);

        result = LinkParser.parseLink(stackoverflowLink);
        Assert.assertEquals("654321", result);

        result = LinkParser.parseLink(invalidLink);
        Assert.assertNull(result);
    }
}