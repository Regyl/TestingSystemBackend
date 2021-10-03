package rut.miit.testingsystem.professor.answer;

import rut.miit.testingsystem.professor.answer.dto.request.AnswerDTOCreateRequest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
public class Answer {
    @Id
    @GeneratedValue
    @Column
    @NotNull
    private UUID id;

    @Column
    @NotNull
    private UUID questionId;

    @Column
    @NotNull
    private Boolean isCorrect;

    public Answer() {}

    public Answer(AnswerDTOCreateRequest createRequest) {
        this.questionId=createRequest.getQuestionId();
        this.isCorrect=createRequest.getCorrect();
    }

    public Boolean getCorrect() {
        return isCorrect;
    }

    public void setCorrect(Boolean correct) {
        isCorrect = correct;
    }

    public UUID getQuestionId() {
        return questionId;
    }

    public void setQuestionId(UUID questionId) {
        this.questionId = questionId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
