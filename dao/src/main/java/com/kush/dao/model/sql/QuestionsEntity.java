package com.kush.dao.model.sql;

import com.kush.common.id.UUIDBased;
import com.kush.common.question.Options;
import com.kush.common.question.QuestionLevel;
import com.kush.common.question.Questions;
import com.kush.dao.model.BaseSqlEntity;
import com.kush.dao.model.ModelConstants;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = ModelConstants.QUESTIONS_TABLE)
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class QuestionsEntity extends BaseSqlEntity<Questions> {

    @Column(nullable = false, name = ModelConstants.QUESTIONS_CATEGORY_COLUMN)
    private String category;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = ModelConstants.QUESTIONS_DIFFICULTY_COLUMN)
    private QuestionLevel difficultyLevel;

    @Column(nullable = false, name = ModelConstants.QUESTIONS_QUESTION_COLUMN)
    private String question;

    @Column(nullable = false, name = ModelConstants.QUESTIONS_OPTIONA_COLUMN)
    private String optionA;

    @Column(nullable = false, name = ModelConstants.QUESTIONS_OPTIONB_COLUMN)
    private String optionB;

    @Column(nullable = false, name = ModelConstants.QUESTIONS_OPTIONC_COLUMN)
    private String optionC;

    @Column(nullable = false, name = ModelConstants.QUESTIONS_OPTIOND_COLUMN)
    private String optionD;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = ModelConstants.QUESTIONS_ANSWER_COLUMN)
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
        Questions questions = new Questions(id);
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
