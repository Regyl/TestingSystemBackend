package rut.miit.testingsystem.api.controller.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import rut.miit.testingsystem.api.controller.dto.response.AbstractDtoResponse;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
public class AnswerDtoResponse extends AbstractDtoResponse {
    private UUID id;

    private UUID questionId;

    private Boolean isCorrect;

    private String text;
}
