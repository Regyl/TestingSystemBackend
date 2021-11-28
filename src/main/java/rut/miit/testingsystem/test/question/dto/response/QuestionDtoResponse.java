package rut.miit.testingsystem.test.question.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import rut.miit.testingsystem.ObjectDTOCreateResponse;
import rut.miit.testingsystem.test.Test;
import rut.miit.testingsystem.test.answer.Answer;
import rut.miit.testingsystem.test.answer.dto.response.AnswerDtoResponse;
import rut.miit.testingsystem.test.question.Question;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.UUID;

@Data
@EqualsAndHashCode(exclude = "answers")
public class QuestionDtoResponse extends ObjectDTOCreateResponse {

    private UUID id;

    private String text;

    private String additionalInfo;

    private UUID testId;

    private Set<AnswerDtoResponse> answers;

}
