package com.kush.data.question;

import com.kush.data.BaseData;
import com.kush.data.id.UUIDBased;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@Builder
public class Questions extends BaseData<UUIDBased> {

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

    public Questions(UUIDBased id){
        super(id);
    }

    public Questions(Questions q){
        super(q.getId());
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
