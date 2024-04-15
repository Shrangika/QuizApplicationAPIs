package com.springboot.Quiz.Application.service.impl;

import com.springboot.Quiz.Application.dto.QuestionDto;
import com.springboot.Quiz.Application.entity.Question;
import com.springboot.Quiz.Application.mapper.QuestionMapper;
import com.springboot.Quiz.Application.repository.QuestionRepository;
import com.springboot.Quiz.Application.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionRepository questionRepository;

    @Override
    public QuestionDto create(QuestionDto questionDto) {
        Question question = QuestionMapper.mapToQuestion(questionDto);
        Question savedQuestion = questionRepository.save(question);
        return QuestionMapper.mapToQuestionDto(savedQuestion);

    }

    @Override
    public List<QuestionDto> getAllQuestions() {
        List<Question> questions= questionRepository.findAll();
        return questions.stream().map((question) -> QuestionMapper.mapToQuestionDto(question))
                .collect(Collectors.toList());

    }

    @Override
    public QuestionDto update(QuestionDto questionDto, Long questionId) {
        Question question = questionRepository.findById(questionId).orElseThrow(()-> new RuntimeException("Question not found error"));

        question.setCategory(questionDto.getCategory());
        question.setDifficultyLevel(questionDto.getDifficultyLevel());
        question.setOption1(questionDto.getOption1());
        question.setOption2(questionDto.getOption2());
        question.setOption3(questionDto.getOption3());
        question.setOption4(questionDto.getOption4());
        question.setQuestionTitle(questionDto.getQuestionTitle());
        question.setRightAnswer(questionDto.getRightAnswer());

        Question savedQuestion = questionRepository.save(question);
        return QuestionMapper.mapToQuestionDto(savedQuestion);
    }

    @Override
    public void deleteQuestion(Long id) {
        Question question = questionRepository.findById(id).orElseThrow(()->new RuntimeException("Question not found"));
        questionRepository.delete(question);
    }

    @Override
    public List<QuestionDto> getQuestionsByCategory(String category) {
        List<Question> questions= questionRepository.findByCategory(category);
        return questions.stream().map((question) -> QuestionMapper.mapToQuestionDto(question))
                .collect(Collectors.toList());
    }
}
