package rut.miit.testingsystem.professor.answer.dto.request;

import rut.miit.testingsystem.ObjectDTOCreateResponse;
import rut.miit.testingsystem.professor.answer.Answer;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class AnswerDTOCreateRequest {
    @NotNull
    private UUID questionId;

    @NotNull
    private Boolean isCorrect;

    public AnswerDTOCreateRequest() {}

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
}
