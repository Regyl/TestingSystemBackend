package rut.miit.testingsystem.entity;

import lombok.Data;
import rut.miit.testingsystem.entity.Student;
import rut.miit.testingsystem.entity.Test;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Data
public class StudentResult {
    @Id
    @GeneratedValue
    private UUID id;

    @NotNull
    @OneToOne
    private Student student;

    @NotNull
    @OneToOne
    private Test test;

    @NotNull
    private Double resultScore;
}
