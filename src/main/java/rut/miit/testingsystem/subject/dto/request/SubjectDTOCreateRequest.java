package rut.miit.testingsystem.subject.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import rut.miit.testingsystem.subject.faculty.Faculty;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class SubjectDTOCreateRequest {
    @NotNull
    private String name;

    @NotNull
    private Faculty faculty;
}
