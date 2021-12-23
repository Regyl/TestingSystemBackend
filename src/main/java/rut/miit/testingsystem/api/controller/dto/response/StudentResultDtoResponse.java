package rut.miit.testingsystem.api.controller.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import rut.miit.testingsystem.api.controller.dto.response.AbstractDtoResponse;
import rut.miit.testingsystem.api.controller.dto.response.response.StudentDtoResponse;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
public class StudentResultDtoResponse extends AbstractDtoResponse {

    private UUID id;

    private StudentDtoResponse student;

    private UUID testId;

    private Double resultScore;
}
