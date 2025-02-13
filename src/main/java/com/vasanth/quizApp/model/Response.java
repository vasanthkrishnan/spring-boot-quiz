package com.vasanth.quizApp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Setter
@Getter
public class Response {
    private int id;
    private String res;


    public void setRes(String res) {
        this.res = res;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getRes() {
        return res;
    }
}
