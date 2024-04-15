package com.springboot.Quiz.Application.entity;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String category;
    @Enumerated(EnumType.STRING)
    private Difficulty difficultyLevel;
    @NotNull
    private String option1;
    @NotNull
    private String option2;
    @NotNull
    private String option3;
    @NotNull
    private String option4;
    @NotNull
    private String questionTitle;
    @NotNull
    private String rightAnswer;

}
