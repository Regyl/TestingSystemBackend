package rut.miit.testingsystem.subject;

import lombok.Data;
import lombok.NoArgsConstructor;
import rut.miit.testingsystem.subject.dto.request.SubjectDTOCreateRequest;

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
    @Column
    @NotNull
    private UUID id;

    @Column
    @NotNull
    private String name;

    public Subject(SubjectDTOCreateRequest createRequest) {
        this.name=createRequest.getName();
    }
}
