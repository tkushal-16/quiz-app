package com.kush.dao.questions;

import com.kush.dao.Dao;
import com.kush.data.question.Questions;

import java.util.List;

public interface QuestionsDao extends Dao<Questions> {

    List<Questions> saveAll(List<Questions> questions);
}
