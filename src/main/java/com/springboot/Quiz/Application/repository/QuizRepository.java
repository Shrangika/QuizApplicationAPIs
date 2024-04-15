package com.springboot.Quiz.Application.repository;

import com.springboot.Quiz.Application.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

}
