package rut.miit.testingsystem.studentgroup;

import rut.miit.testingsystem.studentgroup.dto.request.StudentGroupDTOCreateRequest;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table
public class StudentGroup {

    @Id
    @GeneratedValue
    @Column(unique = true)
    @NotNull
    private UUID id;

    @Column(unique = true)
    @NotNull
    private String shortName;

    @Column
    @NotNull
    private Integer number;

    public StudentGroup() {}

    public StudentGroup(StudentGroupDTOCreateRequest createRequest) {
        this.shortName=createRequest.getShortName();
        this.number=createRequest.getNumber();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
