package com.Quiz.Quiz.ServiceImpl;

import com.Quiz.Quiz.Model.Question;
import com.Quiz.Quiz.Model.QuestionWapper;
import com.Quiz.Quiz.Model.Quiz;
import com.Quiz.Quiz.Model.Response;
import com.Quiz.Quiz.Repository.QuestionRepository;
import com.Quiz.Quiz.Repository.QuizRepository;
import com.Quiz.Quiz.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizServiceImpl implements QuizService {
    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private QuestionRepository questionRepository;
    private static final Logger logger = LoggerFactory.getLogger(QuizServiceImpl.class);


    @Override
    public List<Quiz> allQuiz() {
        return quizRepository.findAll();
    }

    @Override
    public Quiz getById(Long id) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        return quiz.orElse(null);
    }


    @Override
    public ResponseEntity<String> createQuiz(String category, int noOfQuiz, String title) {

        List<Question> queList = questionRepository.findRandomQuestionByCategory(category, noOfQuiz);
        logger.info("here we are");
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(queList);


        quizRepository.save(quiz);
        return new ResponseEntity<>("done", HttpStatus.OK);
    }


    public ResponseEntity<List<QuestionWapper>> getQuizQuestion(Long id) {

        Optional<Quiz> q = quizRepository.findById(id);
//        List<Question> que=q.get().getQuestions();
//       Quiz q= getById(id);
        List<Question> que = q.get().getQuestions();
        List<QuestionWapper> qw = new ArrayList<>();
        for (Question question : que) {
            QuestionWapper tempQw = new QuestionWapper(question.getQ_id(), question.getQue(), question.getOption1(), question.getOption2(), question.getOption3(), question.getOption4());
            qw.add(tempQw);
        }
        return new ResponseEntity<>(qw,HttpStatus.OK);


    }

    public ResponseEntity<Integer> submitResponse(Integer id,List<Response> responses) {
        long l=(long)id;
        Quiz q=quizRepository.findById(l).get();
        List<Question>que=q.getQuestions();
        Integer score=0;
        int i=0;
        for(Response res:responses){
            if(res.getResponse().equals(que.get(i).getAns()) ){
                score++;
            }
            i++;
        }
        return new ResponseEntity<>(score,HttpStatus.OK);


    }
}


