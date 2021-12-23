package rut.miit.testingsystem.api.controller.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
public class SubjectDtoResponse extends AbstractDtoResponse {

    private UUID id;

    private String name;

    private FacultyDtoResponse faculty;

}
