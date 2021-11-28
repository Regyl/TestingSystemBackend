package rut.miit.testingsystem.test.question.dto.response;

import lombok.Data;
import rut.miit.testingsystem.ObjectDTOCreateResponse;
import rut.miit.testingsystem.test.question.Question;

@Data
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
