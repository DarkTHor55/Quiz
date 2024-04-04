package com.Quiz.Quiz.ServiceImpl;

import com.Quiz.Quiz.Model.Question;
import com.Quiz.Quiz.Repository.QuestionRepository;
import com.Quiz.Quiz.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository queRepository;
    @Override
    public List<Question> AllQuestion() {
        return queRepository.findAll() ;
    }

    @Override
    public List<Question> getByCaegory(String category) {
        return queRepository.findByCategory(category);
    }

    @Override
    public Boolean AddQuestion(Question question) {
        try {
            queRepository.save(question);
            return true;
        }
        catch (Exception ex) {
            return false;
        }


    }
    private boolean CheckValid(Long id){
        List<Question>ls=AllQuestion();
        for(Question que:ls){
            if(id==que.getQ_id()){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean DeleteQuestion(Long id) {
        if(CheckValid(id)){
            queRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateQuestion(Long id,Question que) {
        if(CheckValid(id)){
            que.setQ_id(id);
            queRepository.deleteById(id);
            queRepository.save(que);
            return true;
        }

        return false;
    }
}
