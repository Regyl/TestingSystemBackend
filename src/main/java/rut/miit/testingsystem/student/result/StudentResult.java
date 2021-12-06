package rut.miit.testingsystem.student.result;

import lombok.Data;
import lombok.NoArgsConstructor;
import rut.miit.testingsystem.student.Student;
import rut.miit.testingsystem.test.Test;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
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
    private double resultScore;
}
