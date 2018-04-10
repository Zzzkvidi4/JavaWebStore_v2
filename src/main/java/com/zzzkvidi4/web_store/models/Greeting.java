package com.zzzkvidi4.web_store.models;

import java.util.concurrent.atomic.AtomicLong;

public class Greeting {
    private long number;
    private String content;

    public Greeting(long number, String content) {
        this.number = number;
        this.content = content;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
