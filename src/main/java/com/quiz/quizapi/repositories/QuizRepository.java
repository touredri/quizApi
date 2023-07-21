package com.quiz.quizapi.repositories;

import com.quiz.quizapi.models.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
