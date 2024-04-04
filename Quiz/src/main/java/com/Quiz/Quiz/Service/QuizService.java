package com.Quiz.Quiz.Service;

import com.Quiz.Quiz.Model.Quiz;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuizService {
    List<Quiz> allQuiz();
    Quiz getById(Long id);

    ResponseEntity<String> createQuiz(String category, int noOfQuiz, String title);



}
