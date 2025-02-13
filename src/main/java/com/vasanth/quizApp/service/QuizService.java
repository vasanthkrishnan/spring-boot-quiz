package com.vasanth.quizApp.service;

import com.vasanth.quizApp.model.Question;
import com.vasanth.quizApp.model.QuestionWrapper;
import com.vasanth.quizApp.model.Quiz;
import com.vasanth.quizApp.repository.QuestionRepo;
import com.vasanth.quizApp.repository.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizRepo quizRepo;

    @Autowired
    QuestionRepo questionRepo;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Question> questions = questionRepo.findRandomQuestionsByCategory(category, numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepo.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);

    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionForUser(int id) {
        Optional<Quiz> quiz = quizRepo.findById(id);
        List<Question> questionsFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionForUser = new ArrayList<>();
        for(Question q : questionsFromDB) {
            QuestionWrapper questionWrapper = new QuestionWrapper(q.getId(), q.getQuestion(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            questionForUser.add(questionWrapper);
        }

        return new ResponseEntity<>(questionForUser, HttpStatus.OK);
    }
}
