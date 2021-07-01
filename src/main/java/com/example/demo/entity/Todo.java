package com.example.demo.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import java.beans.JavaBean;
@EntityScan
public class Todo {
    private int id;
    private String content;
    private int state;

    public Todo(String content) {
        this.content = content;
    }

    public Todo(String content, int state) {
        this.content = content;
        this.state = state;
    }

    public Todo(int id, String content, int state) {
        this.id = id;
        this.content = content;
        this.state = state;
    }

    public Todo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", state=" + state +
                '}';
    }
}
