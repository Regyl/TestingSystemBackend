package rut.miit.testingsystem.test.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import rut.miit.testingsystem.AbstractDtoResponse;
import rut.miit.testingsystem.subject.Subject;
import rut.miit.testingsystem.subject.dto.response.SubjectDtoResponse;
import rut.miit.testingsystem.test.question.dto.response.QuestionDtoResponse;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Data
@EqualsAndHashCode(exclude = "questions", callSuper = true)
public class TestDtoResponse extends AbstractDtoResponse {

    private UUID id;

    private SubjectDtoResponse subject;

    private String name;

    private LocalDate startsAt;

    private LocalDate endsAt;

    private Integer term; //Семестр, для которого доступен тест

    private Set<QuestionDtoResponse> questions;
}
