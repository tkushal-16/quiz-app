package com.kush.application.service;

import com.kush.data.question.Questions;

import java.util.List;

public interface QuestionsDaoService {

    List<Questions> saveAll(List<Questions> questions);
}
