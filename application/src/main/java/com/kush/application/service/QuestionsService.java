package com.kush.application.service;

import com.kush.dao.model.sql.QuestionsEntity;
import com.kush.dao.questions.QuestionsDao;
import com.kush.dao.questions.QuestionsRepository;
import com.kush.data.question.Questions;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor()
public class QuestionsService {

    private final QuestionsDaoService questionsDaoService;


    public List<Questions> saveAllQuestions(List<Questions> questions) {
        return questionsDaoService.saveAll(questions);
    }
}
