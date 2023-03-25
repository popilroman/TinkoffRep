package com.tinkoff.project;

public class App 
{
    public static void main( String[] args )
    {
        String gitHubResult = LinkParser.parseLink("https://github.com/sanyarnd/tinkoff-java-course-2022/");
        System.out.println(gitHubResult);
        String stackOverflowResult = LinkParser.parseLink("https://stackoverflow.com/questions/1642028/what-is-the-operator-in-c");
        System.out.println(stackOverflowResult);
        String incorrectResult = LinkParser.parseLink("https://stackoverflow.com/search?q=unsupported%20link");
        System.out.println(incorrectResult);
    }
}
