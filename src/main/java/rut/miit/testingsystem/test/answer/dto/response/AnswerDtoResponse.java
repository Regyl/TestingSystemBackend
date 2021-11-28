package rut.miit.testingsystem.test.answer.dto.response;

import lombok.Data;
import rut.miit.testingsystem.ObjectDTOCreateResponse;
import rut.miit.testingsystem.test.answer.Answer;
import rut.miit.testingsystem.test.question.Question;
import rut.miit.testingsystem.test.question.dto.response.QuestionDTOCreateResponse;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class AnswerDtoResponse extends ObjectDTOCreateResponse {
    private UUID id;

    private QuestionDTOCreateResponse question;

    private Boolean isCorrect;

    private String text;
}
