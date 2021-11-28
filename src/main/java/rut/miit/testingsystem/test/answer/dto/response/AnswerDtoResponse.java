package rut.miit.testingsystem.test.answer.dto.response;

import lombok.Data;
import rut.miit.testingsystem.ObjectDTOCreateResponse;
import rut.miit.testingsystem.test.question.dto.response.QuestionDtoResponse;

import java.util.UUID;

@Data
public class AnswerDtoResponse extends ObjectDTOCreateResponse {
    private UUID id;

    private UUID questionId;

    private Boolean isCorrect;

    private String text;
}
