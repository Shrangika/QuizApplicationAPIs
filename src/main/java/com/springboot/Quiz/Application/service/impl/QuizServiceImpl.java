package com.springboot.Quiz.Application.service.impl;

import com.springboot.Quiz.Application.dto.QuizDto;
import com.springboot.Quiz.Application.dto.Response;
import com.springboot.Quiz.Application.entity.Question;
import com.springboot.Quiz.Application.entity.Quiz;
import com.springboot.Quiz.Application.repository.QuestionRepository;
import com.springboot.Quiz.Application.repository.QuizRepository;
import com.springboot.Quiz.Application.service.QuizService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class QuizServiceImpl implements QuizService {
  QuizRepository quizRepository;
  QuestionRepository questionRepository;
    @Override
    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question> questions = questionRepository.findRandomQuestionsByCategory(category,numQ);

       Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepository.save(quiz);
System.out.println(numQ);
System.out.println(title);
        return ResponseEntity.ok("Success");
    }

    @Override
    public ResponseEntity<List<QuizDto>> getQuizById(Long id) {
        Optional<Quiz> quiz=quizRepository.findById(id);
        List<Question> questions = quiz.get().getQuestions();
        List<QuizDto> quizDtos = new ArrayList<>();

        for(Question q:questions)
        {
            QuizDto quizDto=new QuizDto(q.getId(),q.getCategory(),q.getDifficultyLevel(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4(),q.getQuestionTitle());
            quizDtos.add(quizDto);
        }
        return new ResponseEntity<>(quizDtos, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Integer> calculateResult(Long id, List<Response> responses) {
        Quiz quiz=quizRepository.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        int right =0;
        int i=0;
        for(Response response:responses)
        {
            if(response.getAnswer().equals(questions.get(i).getRightAnswer()))
                right++;
            i++;
        }
        return new ResponseEntity<>(right, HttpStatus.OK);
    }
}
