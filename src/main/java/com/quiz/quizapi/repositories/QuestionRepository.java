package com.quiz.quizapi.repositories;

import com.quiz.quizapi.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository <Question, Long>{

}
