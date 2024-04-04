package com.Quiz.Quiz.Model;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class QuestionWapper {
    private Long q_id;
    private String que;
    private String option1;
    private String option2;
    private String option3;
    private String option4;


    public QuestionWapper(Long q_id, String que, String option1, String option2, String option3, String option4) {
        this.q_id = q_id;
        this.que = que;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
    }
}
