package com.kush.application.service;

import com.kush.common.question.Questions;
import com.kush.common.questions.QuestionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionsServiceImpl {

    @Autowired
    private final QuestionsService questionsService;


    public List<Questions> saveAllQuestions(List<Questions> questions) {
        return questionsService.saveAll(questions);
    }

}
