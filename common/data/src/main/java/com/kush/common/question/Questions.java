package com.kush.common.question;


import com.kush.common.BaseData;
import com.kush.common.id.UUIDBased;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@Builder
public class Questions extends BaseData<UUIDBased> implements Serializable {

    private String category;

    private QuestionLevel difficultyLevel;

    private String question;

    private String optionA;

    private String optionB;

    private String optionC;

    private String optionD;

    private Options answer;

    public Questions() {
        super();
    }

    public Questions(UUID id){
        super(id);
    }

    public Questions(Questions q){
        super();
        this.id = q.getId();
        this.createdTime = q.getCreatedTime();
        this.category = q.getCategory();
        this.difficultyLevel = q.getDifficultyLevel();
        this.question = q.getQuestion();
        this.optionA = q.getOptionA();
        this.optionB = q.getOptionB();
        this.optionC = q.getOptionC();
        this.optionD = q.getOptionD();
        this.answer = q.getAnswer();
    }
}
