package com.Quiz.Quiz.Service;

import com.Quiz.Quiz.Model.Question;

import java.util.List;

public interface QuestionService {
    List<Question> AllQuestion() ;
    List<Question> getByCaegory(String str);
    Boolean AddQuestion(Question question);
    boolean DeleteQuestion(Long id);
    boolean updateQuestion(Long id,Question que );
}
