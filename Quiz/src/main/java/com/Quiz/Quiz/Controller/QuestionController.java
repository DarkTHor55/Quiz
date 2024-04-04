package com.Quiz.Quiz.Controller;

import com.Quiz.Quiz.Model.Question;
import com.Quiz.Quiz.Service.QuestionService;
import com.Quiz.Quiz.ServiceImpl.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("que")
public class QuestionController {

    private final QuestionServiceImpl questionService;

    @Autowired
    QuestionController(QuestionServiceImpl questionService){
        this.questionService=questionService;
    }

    @GetMapping("/test")
    public String test(){
        return"testing......";
    }
    @GetMapping("AllQuestion")
    public List<Question> Question(){

        return questionService.AllQuestion();

    }
    @PostMapping("/question")
    public ResponseEntity<String> AddQuestion(@RequestBody Question que){
        Boolean res=questionService.AddQuestion(que);
        if(res){
            return new ResponseEntity<String>("Created Sucessfully .....", HttpStatus.OK);
        }else{
            return new ResponseEntity<String>("Somthing Went Wrong .....", HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{q_id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Long q_id ){
        boolean a;
        a=questionService.DeleteQuestion(q_id);
        if(a){
           return new ResponseEntity<String>("Deleted....",HttpStatus.OK);
        }else {
            return new ResponseEntity<String>("Question not present ....",HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/{q_id}")
    public ResponseEntity<String> updateQuestion(@PathVariable Long q_id,@RequestBody Question question){
        boolean a;
        a=questionService.updateQuestion(q_id,question);
        if(a){
            return new ResponseEntity<String>("Updated....",HttpStatus.OK);
        }else {
            return new ResponseEntity<String>("Question not present ....",HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/Category/{category}")
    public List<Question> getByCategory(@PathVariable String category){
        return questionService.getByCaegory(category);
    }

}
