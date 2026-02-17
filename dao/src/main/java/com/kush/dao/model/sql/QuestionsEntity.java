package com.kush.dao.model.sql;

import com.kush.dao.model.BaseSqlEntity;
import com.kush.data.question.Options;
import com.kush.data.question.QuestionLevel;
import com.kush.data.question.Questions;
import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Entity
@Table(name = "questions")
@EqualsAndHashCode(callSuper = true)
public class QuestionsEntity extends BaseSqlEntity<Questions> {

    @Column(nullable = false, name = "category")
    private String category;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "difficultyLevel")
    private QuestionLevel difficultyLevel;

    @Column(nullable = false, name = "question")
    private String question;

    @Column(nullable = false, name = "optionA")
    private String optionA;

    @Column(nullable = false, name = "optionB")
    private String optionB;

    @Column(nullable = false, name = "optionC")
    private String optionC;

    @Column(nullable = false, name = "optionD")
    private String optionD;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "answer")
    private Options answer;

    public QuestionsEntity() {
        super();
    }

    public QuestionsEntity(Questions question) {
        if (question.getId() != null) {
            this.setUuid(question.getUuidId());
        }
        this.setCreatedTime(question.getCreatedTime());
        this.category = question.getCategory();
        this.difficultyLevel = question.getDifficultyLevel();
        this.question = question.getQuestion();
        this.optionA = question.getOptionA();
        this.optionB = question.getOptionB();
        this.optionC = question.getOptionC();
        this.optionD = question.getOptionD();
        this.answer = question.getAnswer();

    }

    @Override
    public Questions toData() {
        Questions questions = new Questions();
        questions.setCreatedTime(createdTime);
        questions.setCategory(category);
        questions.setDifficultyLevel(difficultyLevel);
        questions.setQuestion(question);
        questions.setOptionA(optionA);
        questions.setOptionB(optionB);
        questions.setOptionC(optionC);
        questions.setOptionD(optionD);
        questions.setAnswer(answer);
        return questions;
    }
}
