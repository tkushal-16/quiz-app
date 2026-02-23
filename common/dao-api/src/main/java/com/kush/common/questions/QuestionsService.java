package com.kush.common.questions;


import com.kush.common.question.Questions;

import java.util.List;

public interface QuestionsService {

    List<Questions> saveAll(List<Questions> questions);

    Questions saveOne(Questions questions);

    List<Questions> findAll();
}
