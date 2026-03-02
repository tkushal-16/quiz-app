package com.kush.dao.questions;

import com.kush.common.question.Questions;
import com.kush.dao.Dao;

import java.util.List;

public interface QuestionsDao extends Dao<Questions> {

    List<Questions> saveAll(List<Questions> questions);

    List<Questions> findAllQuestions();
}
