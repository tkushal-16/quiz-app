package com.kush.dao.questions;

import com.google.common.util.concurrent.ListenableFuture;
import com.kush.dao.JpaAbstractDao;
import com.kush.dao.model.sql.QuestionsEntity;
import com.kush.data.question.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class JpaQuestionsDao extends JpaAbstractDao<QuestionsEntity, Questions> implements QuestionsDao {

    private QuestionsRepository questionsRepository;

    @Override
    protected Class<QuestionsEntity> getEntityClass() {
        return null;//questionsRepository.getClass();
    }

    @Override
    protected JpaRepository<QuestionsEntity, UUID> getRepository() {
        return questionsRepository;
    }

    @Override
    public ListenableFuture<Boolean> existsByIdAsync(UUID id, UUID key) {
        return null;
    }

    @Override
    public ListenableFuture<Questions> findByIdAsync(UUID id, UUID key) {
        return null;
    }
}
