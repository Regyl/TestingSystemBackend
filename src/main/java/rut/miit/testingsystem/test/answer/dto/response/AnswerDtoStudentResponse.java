package rut.miit.testingsystem.test.answer.dto.response;

import lombok.Data;

import java.util.UUID;

@Data
public class AnswerDtoStudentResponse {

    private UUID id;

    private String text;
}
