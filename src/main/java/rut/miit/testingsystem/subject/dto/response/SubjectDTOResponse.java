package rut.miit.testingsystem.subject.dto.response;

import lombok.Data;
import rut.miit.testingsystem.ObjectDTOCreateResponse;
import rut.miit.testingsystem.subject.Subject;
import rut.miit.testingsystem.subject.faculty.Faculty;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class SubjectDTOResponse extends ObjectDTOCreateResponse {

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
