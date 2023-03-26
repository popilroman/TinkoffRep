package com.tinkoff.project.dto;

public class ScrapperRequest {

    private String url;

    public ScrapperRequest() {
    }

    public ScrapperRequest(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
