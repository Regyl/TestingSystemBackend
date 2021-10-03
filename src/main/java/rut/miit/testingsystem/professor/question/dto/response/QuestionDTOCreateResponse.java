package rut.miit.testingsystem.professor.question.dto.response;

import rut.miit.testingsystem.ObjectDTOCreateResponse;
import rut.miit.testingsystem.professor.question.Question;

import java.time.LocalDateTime;

public class QuestionDTOCreateResponse extends ObjectDTOCreateResponse {

    private Question question;

    public QuestionDTOCreateResponse(Question question) {
        super();
        this.question=question;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
