/**
 * Copyright © 2016-2026 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.kush.dao.model;

import com.kush.common.question.Options;
import com.kush.common.question.QuestionLevel;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class ModelConstants {

    private ModelConstants() {}


    // this is the difference between midnight October 15, 1582 UTC and midnight January 1, 1970 UTC as 100 nanosecond units
    public static final long EPOCH_DIFF = 122192928000000000L;

    /**
     * Generic constants.
     */
    public static final String ID_PROPERTY = "id";
    public static final String CREATED_TIME_PROPERTY = "created_time";

    public static final String ENTITY_TYPE_PROPERTY = "entity_type";
    public static final String VERSION_PROPERTY = "version";

    public static final String ENTITY_TYPE_COLUMN = ENTITY_TYPE_PROPERTY;


    /**
     * Questions Entity Constants
     */

    public static final String QUESTIONS_TABLE = "questions";
    public static final String QUESTIONS_CATEGORY_COLUMN = "category";
    public static final String QUESTIONS_DIFFICULTY_COLUMN = "difficulty_level";
    public static final String QUESTIONS_QUESTION_COLUMN = "question";
    public static final String QUESTIONS_OPTIONA_COLUMN = "optiona";
    public static final String QUESTIONS_OPTIONB_COLUMN = "optionb";
    public static final String QUESTIONS_OPTIONC_COLUMN = "optionc";
    public static final String QUESTIONS_OPTIOND_COLUMN = "optiond";
    public static final String QUESTIONS_ANSWER_COLUMN = "answer";

}
