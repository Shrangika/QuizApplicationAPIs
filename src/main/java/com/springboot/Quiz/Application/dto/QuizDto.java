package com.springboot.Quiz.Application.dto;

import com.springboot.Quiz.Application.entity.Difficulty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuizDto {
    private Long id;
    private String category;
    private Difficulty difficultyLevel;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String questionTitle;
}
