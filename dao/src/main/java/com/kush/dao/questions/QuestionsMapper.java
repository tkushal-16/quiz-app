package com.kush.dao.questions;

import com.kush.common.question.Questions;
import com.kush.dao.model.sql.QuestionsEntity;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public final class QuestionsMapper {

    private QuestionsMapper() {
        // Prevent instantiation
    }

    public static Questions toDomain(QuestionsEntity entity) {
        if (entity == null) {
            return null;
        }

        Questions question = new Questions(entity.getId());
        question.setCreatedTime(entity.getCreatedTime());
        question.setQuestion(entity.getQuestion());
        question.setDifficultyLevel(entity.getDifficultyLevel());
        question.setOptionA(entity.getOptionA());
        question.setOptionB(entity.getOptionB());
        question.setOptionC(entity.getOptionC());
        question.setOptionD(entity.getOptionD());
        question.setAnswer(entity.getAnswer());
        question.setCategory(entity.getCategory());

        return question;
    }

    public static QuestionsEntity toEntity(Questions domain) {
        if (domain == null) {
            return null;
        }
        QuestionsEntity entity = new QuestionsEntity();
        entity.setId((domain.getUuidId() == null) ? UUID.randomUUID() : domain.getUuidId());
        entity.setCreatedTime((domain.getCreatedTime() != 0L) ? domain.getCreatedTime() : System.currentTimeMillis() );
        entity.setQuestion(domain.getQuestion());
        entity.setDifficultyLevel(domain.getDifficultyLevel());
        entity.setOptionA(domain.getOptionA());
        entity.setOptionB(domain.getOptionB());
        entity.setOptionC(domain.getOptionC());
        entity.setOptionD(domain.getOptionD());
        entity.setAnswer(domain.getAnswer());
        entity.setCategory(domain.getCategory());

        return entity;
    }

    public static List<Questions> toDomainList(List<QuestionsEntity> entities) {
        return entities.stream()
                .map(QuestionsMapper::toDomain)
                .collect(Collectors.toList());
    }

    public static List<QuestionsEntity> toEntityList(List<Questions> domains) {
        return domains.stream()
                .map(QuestionsMapper::toEntity)
                .collect(Collectors.toList());
    }
}