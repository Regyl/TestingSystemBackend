package rut.miit.testingsystem.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Data
public class StudentGroup {

    @Id
    @GeneratedValue
    private UUID id;

    @NotNull
    private String shortName;

    @NotNull
    private Integer number;
}
