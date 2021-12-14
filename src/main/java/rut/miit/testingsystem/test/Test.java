package rut.miit.testingsystem.test;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import rut.miit.testingsystem.subject.Subject;
import rut.miit.testingsystem.test.question.Question;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "test")
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = "questions")
public class Test {
    @Id
    @GeneratedValue
    private UUID id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @NotNull
    private String name;

    private LocalDate startsAt;

    private LocalDate endsAt;

    private Integer term; //Семестр, для которого доступен тест

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "test")
    private Set<Question> questions;
}
