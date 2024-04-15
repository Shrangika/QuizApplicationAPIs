package com.springboot.Quiz.Application.controller;

import com.springboot.Quiz.Application.dto.QuizDto;
import com.springboot.Quiz.Application.dto.Response;
import com.springboot.Quiz.Application.service.QuizService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/quiz")
public class QuizController {

    QuizService quizService;
    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam(defaultValue = "4") int numQ, @RequestParam String title)
    {

        return quizService.createQuiz(category,numQ,title);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<QuizDto>> getQuizById(@PathVariable Long id)
    {
        return quizService.getQuizById(id);
    }

    @PostMapping("/submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Long id,@RequestBody List<Response> responses)
    {

        return quizService.calculateResult(id,responses);
    }

}
