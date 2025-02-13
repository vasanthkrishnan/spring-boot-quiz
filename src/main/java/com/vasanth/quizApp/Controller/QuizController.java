package com.vasanth.quizApp.Controller;

import com.vasanth.quizApp.model.Question;
import com.vasanth.quizApp.model.QuestionWrapper;
import com.vasanth.quizApp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title) {
        return quizService.createQuiz(category, numQ, title);
    }


    @GetMapping("/question/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuestionForUser(@PathVariable int id) {
        return quizService.getQuestionForUser(id);
    }
}
