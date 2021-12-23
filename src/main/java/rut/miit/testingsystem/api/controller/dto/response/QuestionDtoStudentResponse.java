package rut.miit.testingsystem.api.controller.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;
import java.util.UUID;

@Data
@EqualsAndHashCode(exclude = "answers", callSuper = true)
public class QuestionDtoStudentResponse extends AbstractDtoResponse {

    private UUID id;

    private String text;

    private String additionalInfo;

    private UUID testId;

    private Set<AnswerDtoStudentResponse> answers;
}
