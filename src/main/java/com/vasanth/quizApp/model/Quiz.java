package com.vasanth.quizApp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Data
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;

    public List<Question> getQuestions() {
        return questions;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @ManyToMany
    private List<Question> questions;

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
