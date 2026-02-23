package com.kush.dao.questions;

import com.kush.common.question.Questions;
import com.kush.common.questions.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseQuestionsService implements QuestionsService {

    @Autowired
    private QuestionsDao questionsDao;

    @Override
    public List<Questions> saveAll(List<Questions> questions) {
        return questionsDao.saveAll(questions);
    }

    @Override
    public Questions saveOne(Questions questions) {
        return questionsDao.save(questions.getUuidId(),questions);
    }

    @Override
    public List<Questions> findAll() {
        return questionsDao.findAllQuestions();
    }


}
