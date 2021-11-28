package rut.miit.testingsystem.test.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import rut.miit.testingsystem.ObjectDTOCreateResponse;
import rut.miit.testingsystem.subject.Subject;
import rut.miit.testingsystem.test.Test;
import rut.miit.testingsystem.test.question.Question;
import rut.miit.testingsystem.test.question.dto.response.QuestionDtoResponse;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Data
@EqualsAndHashCode(exclude = "questions")
public class TestDtoResponse extends ObjectDTOCreateResponse {

    private UUID id;

    private Subject subject;

    private String name;

    private LocalDate startsAt;

    private LocalDate endsAt;

    private Integer term; //Семестр, для которого доступен тест

    private Set<QuestionDtoResponse> questions;
}
