package com.kush.application.controller;

import com.kush.common.question.Questions;
import com.kush.common.questions.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionsService questionsService;

    @PostMapping("/bulk")
    public ResponseEntity<List<Questions>> saveBulkQuestions(@RequestBody List<Questions> questions) {

        List<Questions> savedQuestions = questionsService.saveAll(questions);
        return ResponseEntity.ok(savedQuestions);
    }

    @PostMapping("/save")
    public Questions saveOne(@RequestBody Questions questions) {
        return questionsService.saveOne(questions);
    }

    @GetMapping("/get")
    public List<Questions> getAllQuestions() {
        return questionsService.findAll();
    }
}