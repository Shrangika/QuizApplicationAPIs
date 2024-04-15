package com.springboot.Quiz.Application.service;

import com.springboot.Quiz.Application.dto.QuestionDto;

import java.util.List;

public interface QuestionService {
    QuestionDto create(QuestionDto questionDto);

    List<QuestionDto> getAllQuestions();

    QuestionDto update(QuestionDto questionDto, Long questionId);

    void deleteQuestion(Long id);

    List<QuestionDto> getQuestionsByCategory(String category);
}
