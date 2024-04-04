package com.Quiz.Quiz.Repository;

import com.Quiz.Quiz.Model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz,Long> {

}
