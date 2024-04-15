package com.springboot.Quiz.Application.service;

import com.springboot.Quiz.Application.dto.QuizDto;
import com.springboot.Quiz.Application.dto.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuizService {

    ResponseEntity<String> createQuiz(String category, int numQ, String title);

    ResponseEntity<List<QuizDto>> getQuizById(Long id);

    ResponseEntity<Integer> calculateResult(Long id, List<Response> responses);
}
