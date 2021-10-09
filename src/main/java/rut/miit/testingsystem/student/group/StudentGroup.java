package rut.miit.testingsystem.student.group;

import lombok.Data;
import lombok.NoArgsConstructor;
import rut.miit.testingsystem.student.group.dto.request.StudentGroupDTOCreateRequest;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class StudentGroup {

    @Id
    @GeneratedValue
    @Column(unique = true)
    @NotNull
    private UUID id;

    @Column(unique = true)
    @NotNull
    private String shortName;

    @NotNull
    private Integer number;

    public StudentGroup(StudentGroupDTOCreateRequest createRequest) {
        this.shortName=createRequest.getShortName();
        this.number=createRequest.getNumber();
    }
}
