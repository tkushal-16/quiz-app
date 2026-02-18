package com.kush.dao.questions;

import com.kush.application.service.QuestionsDaoService;
import com.kush.data.question.Questions;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class BaseQuestionsService implements QuestionsDaoService {

    private QuestionsDao questionsDao;
    private QuestionsRepository questionsRepository;

    @Override
    public List<Questions> saveAll(List<Questions> questions) {
        return questionsDao.saveAll(questions);
    }
}
