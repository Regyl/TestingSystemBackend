package rut.miit.testingsystem.student.result.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import rut.miit.testingsystem.AbstractDtoResponse;
import rut.miit.testingsystem.student.Student;
import rut.miit.testingsystem.test.Test;

import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
public class StudentResultDtoResponse extends AbstractDtoResponse {

    private UUID id;

    private Student student;

    private Test test;

    private double resultScore;
}
