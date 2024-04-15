package com.springboot.Quiz.Application.controller;

import com.springboot.Quiz.Application.dto.QuestionDto;
import com.springboot.Quiz.Application.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/questions")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @PostMapping
    public ResponseEntity<QuestionDto> createQuestion(@RequestBody QuestionDto questionDto)
    {
          return new ResponseEntity<>(
                  questionService.create(questionDto), HttpStatus.CREATED
          );
    }
    @PutMapping("/{id}")
    public ResponseEntity<QuestionDto> updateQuestion(@PathVariable("id") Long questionId,@RequestBody QuestionDto questionDto)
    {
        return new ResponseEntity<>(
                questionService.update(questionDto,questionId), HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<QuestionDto>> getAllQuestions()
    {
        List<QuestionDto> questionDtos = questionService.getAllQuestions();
        return ResponseEntity.ok(questionDtos);
    }

    @GetMapping("/{category}")
    public ResponseEntity<List<QuestionDto>> getQuestionsByCategory(@PathVariable String category)
    {
        List<QuestionDto> questionDtos = questionService.getQuestionsByCategory(category);
        return ResponseEntity.ok(questionDtos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Long id)
    {
        questionService.deleteQuestion(id);
        return ResponseEntity.ok("Question deleted");
    }
}
