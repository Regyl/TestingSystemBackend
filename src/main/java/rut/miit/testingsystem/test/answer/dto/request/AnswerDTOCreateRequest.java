package rut.miit.testingsystem.test.answer.dto.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class AnswerDTOCreateRequest {
    @NotNull
    private UUID questionId;

    @NotNull
    private Boolean isCorrect;

    @NotEmpty
    private String text;
}
