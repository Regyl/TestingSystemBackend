package rut.miit.testingsystem.entity;

import lombok.Data;
import rut.miit.testingsystem.entity.enums.Faculty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "subject")
@Data
public class Subject {
    @Id
    @GeneratedValue
    private UUID id;

    @NotNull
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Faculty faculty;

}
