package rut.miit.testingsystem.test.question;

import lombok.Data;
import lombok.NoArgsConstructor;
import rut.miit.testingsystem.test.Test;
import rut.miit.testingsystem.test.answer.Answer;
import rut.miit.testingsystem.test.question.dto.request.QuestionDto;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "question")
@Data
@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue
    private UUID id;

    @NotEmpty
    @Column(columnDefinition = "TEXT")
    private String text;

    @Column(columnDefinition = "TEXT")
    private String additionalInfo;

    @ManyToOne
    @JoinColumn(name = "test_id")
    @NotNull
    private Test test;

    @OneToMany(
            orphanRemoval = true,
            cascade = CascadeType.ALL,
            mappedBy = "question")
    private Set<Answer> answers;
}
