package rut.miit.testingsystem.subject.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import rut.miit.testingsystem.AbstractDtoResponse;
import rut.miit.testingsystem.subject.Subject;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class SubjectDTOResponse extends AbstractDtoResponse {

    private UUID id;

    private String name;

    private FacultyDtoResponse faculty;

    public SubjectDTOResponse(Subject subject) {
        super();
        this.id=subject.getId();
        this.name=subject.getName();
        this.faculty=FacultyDtoResponse.of(subject.getFaculty());
    }
}
