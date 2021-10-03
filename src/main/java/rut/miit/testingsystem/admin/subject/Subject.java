package rut.miit.testingsystem.admin.subject;

import rut.miit.testingsystem.admin.subject.dto.request.SubjectDTOCreateRequest;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue
    @Column
    @NotNull
    private UUID id;

    @Column
    @NotNull
    private String name;

    public Subject() {}

    public Subject(SubjectDTOCreateRequest createRequest) {
        this.name=createRequest.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
