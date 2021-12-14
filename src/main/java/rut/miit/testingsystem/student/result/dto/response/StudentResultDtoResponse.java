package rut.miit.testingsystem.student.result.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import rut.miit.testingsystem.AbstractDtoResponse;
import rut.miit.testingsystem.student.Student;
import rut.miit.testingsystem.student.dto.response.StudentDtoResponse;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
public class StudentResultDtoResponse extends AbstractDtoResponse {

    private UUID id;

    private StudentDtoResponse student;

    private UUID testId;

    private Double resultScore;
}
