package rut.miit.testingsystem.subject;

import lombok.Data;
import lombok.NoArgsConstructor;
import rut.miit.testingsystem.subject.dto.request.SubjectDTOCreateRequest;
import rut.miit.testingsystem.subject.faculty.Faculty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "subject")
@Data
@NoArgsConstructor
public class Subject {
    @Id
    @GeneratedValue
    private UUID id;

    @NotNull
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Faculty faculty;

    public Subject(SubjectDTOCreateRequest createRequest) {
        this.name=createRequest.getName();
        this.faculty=createRequest.getFaculty();
    }
}
