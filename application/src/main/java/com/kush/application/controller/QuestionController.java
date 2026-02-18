package com.kush.application.controller;

import com.kush.application.service.QuestionsService;
import com.kush.data.question.Questions;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionsService questionService;

    public QuestionController(QuestionsService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/bulk")
    public ResponseEntity<List<Questions>> saveBulkQuestions(@RequestBody List<Questions> questions) {

        List<Questions> savedQuestions = questionService.saveAllQuestions(questions);
        return ResponseEntity.ok(savedQuestions);
    }
}