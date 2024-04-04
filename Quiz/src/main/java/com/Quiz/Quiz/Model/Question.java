package com.Quiz.Quiz.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Question {
    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long q_id;
    private String que;
    private String ans;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String level;
    private String category;



}
