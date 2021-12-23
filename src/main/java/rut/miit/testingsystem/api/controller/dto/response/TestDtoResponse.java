package rut.miit.testingsystem.api.controller.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

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
