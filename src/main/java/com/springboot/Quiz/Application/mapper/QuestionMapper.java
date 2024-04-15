package com.springboot.Quiz.Application.mapper;

import com.springboot.Quiz.Application.dto.QuestionDto;
import com.springboot.Quiz.Application.entity.Question;

public class QuestionMapper {

    public static Question mapToQuestion(QuestionDto questionDto)
    {
        Question question = new Question(questionDto.getId(), questionDto.getCategory(), questionDto.getDifficultyLevel(), questionDto.getOption1(), questionDto.getOption2(), questionDto.getOption3(), questionDto.getOption4(), questionDto.getQuestionTitle(), questionDto.getRightAnswer());
        return question;
    }
    public static QuestionDto mapToQuestionDto(Question question){
        QuestionDto questionDto = new QuestionDto(question.getId(), question.getCategory(), question.getDifficultyLevel(), question.getOption1(), question.getOption2(), question.getOption3(), question.getOption4(), question.getQuestionTitle(), question.getRightAnswer());
        return questionDto;

    }
}
