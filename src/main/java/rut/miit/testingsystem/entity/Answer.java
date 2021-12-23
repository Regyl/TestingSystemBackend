package rut.miit.testingsystem.entity;

import lombok.Data;
import rut.miit.testingsystem.entity.Question;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Data
public class Answer {
    @Id
    @GeneratedValue
    private UUID id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @NotNull
    private Boolean isCorrect;

    @NotNull
    @Column(columnDefinition = "TEXT")
    private String text;
}
