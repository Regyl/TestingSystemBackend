package rut.miit.testingsystem.test.answer;

import lombok.Data;
import lombok.NoArgsConstructor;
import rut.miit.testingsystem.test.answer.dto.request.AnswerDTOCreateRequest;
import rut.miit.testingsystem.test.question.Question;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Answer {
    @Id
    @GeneratedValue
    @NotNull
    private UUID id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @NotNull
    private Boolean isCorrect;


    public Answer(AnswerDTOCreateRequest createRequest, Question question) {
        this.question=question;
        this.isCorrect=createRequest.getCorrect();
    }
}
