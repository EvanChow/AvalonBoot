package com.avalon.entity;

public class Sreeting {
    private final long id;
    private final String content;

    public Sreeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
