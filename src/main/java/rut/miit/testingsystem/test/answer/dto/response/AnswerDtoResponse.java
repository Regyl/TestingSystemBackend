package rut.miit.testingsystem.test.answer.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import rut.miit.testingsystem.AbstractDtoResponse;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
public class AnswerDtoResponse extends AbstractDtoResponse {
    private UUID id;

    private UUID questionId;

    private Boolean isCorrect;

    private String text;
}
