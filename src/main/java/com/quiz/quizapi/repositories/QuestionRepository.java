package com.quiz.quizapi.repositories;

import com.quiz.quizapi.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository <Question, Long>{

}
