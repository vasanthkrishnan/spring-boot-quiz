package com.vasanth.quizApp.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionWrapper {
    private int id;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

    public QuestionWrapper(int id, String question, String option1, String option2, String option3, String option4) {
        this.id = id;
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
    }
}
