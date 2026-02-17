package com.kush.dao.questions;

import com.kush.dao.model.sql.QuestionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface QuestionsRepository extends JpaRepository<QuestionsEntity, UUID> {
}
