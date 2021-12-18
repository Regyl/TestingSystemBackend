package rut.miit.testingsystem.test.answer;

import lombok.Data;
import lombok.NoArgsConstructor;
import rut.miit.testingsystem.test.answer.dto.request.AnswerDto;
import rut.miit.testingsystem.test.question.Question;

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
