package com.Quiz.Quiz.Controller;

import com.Quiz.Quiz.Model.Question;
import com.Quiz.Quiz.Model.QuestionWapper;
import com.Quiz.Quiz.Model.Quiz;
import com.Quiz.Quiz.Model.Response;
import com.Quiz.Quiz.Repository.QuestionRepository;
import com.Quiz.Quiz.Service.QuizService;
import com.Quiz.Quiz.ServiceImpl.QuizServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    private  QuizServiceImpl quizService;

    @Autowired
    private QuestionRepository questionRepository;


//    @Autowired
//    QuizController(QuizServiceImpl quizService){
//        this.quizService=quizService;
//    }

    @GetMapping("all")
    public ResponseEntity allQuize(){
        return new ResponseEntity(quizService.allQuiz(),HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<String>createaQuize( @RequestParam String category,
                                               @RequestParam int noOfQuiz,
                                               @RequestParam String title){

        quizService.createQuiz(category,noOfQuiz,title);


        return new ResponseEntity<>("done...", HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<List<QuestionWapper>> getById(@PathVariable Long id){
//        Quiz q=quizService.getById(id);
//        if(q!=null){
//
//            return new ResponseEntity<>(quizService.getById(id),HttpStatus.OK);
//        }
//        return new ResponseEntity<>("Not vaild",HttpStatus.BAD_REQUEST);

        return quizService.getQuizQuestion(id);
    }
    @PostMapping("/submit/{id}")
    public ResponseEntity<Integer>submitQuiz(@PathVariable Integer id,@RequestBody List<Response> res){
        return quizService.submitResponse(id,res);
    }


}

