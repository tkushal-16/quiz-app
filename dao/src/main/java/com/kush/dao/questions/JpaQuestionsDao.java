package com.kush.dao.questions;

import com.google.common.util.concurrent.ListenableFuture;
import com.kush.common.question.Questions;
import com.kush.dao.DaoUtil;
import com.kush.dao.JpaAbstractDao;
import com.kush.dao.model.sql.QuestionsEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@Slf4j
public class JpaQuestionsDao extends JpaAbstractDao<QuestionsEntity, Questions> implements QuestionsDao {

    @Autowired
    private QuestionsRepository questionsRepository;

    @Override
    protected Class<QuestionsEntity> getEntityClass() {
        return QuestionsEntity.class;
    }

    @Override
    protected JpaRepository<QuestionsEntity, UUID> getRepository() {
        return questionsRepository;
    }

    @Override
    public ListenableFuture<Boolean> existsByIdAsync(UUID id) {
        return null;
    }

    @Override
    public List<UUID> findIdsByUUIDAndIdOffset(UUID id, UUID idOffset, int limit) {
        return List.of();
    }

    @Override
    public ListenableFuture<Questions> findByIdAsync(UUID id) {
        return null;
    }

    @Override
    public List<Questions> saveAll(List<Questions> questions) {
        return QuestionsMapper.toDomainList(questionsRepository.saveAll(QuestionsMapper.toEntityList(questions)));
    }

    @Override
    public List<Questions> findAllQuestions() {
        return QuestionsMapper.toDomainList(questionsRepository.findAll());
    }
}
