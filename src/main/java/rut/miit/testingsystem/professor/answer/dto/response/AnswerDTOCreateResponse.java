package rut.miit.testingsystem.professor.answer.dto.response;

import rut.miit.testingsystem.ObjectDTOCreateResponse;
import rut.miit.testingsystem.professor.answer.Answer;

public class AnswerDTOCreateResponse extends ObjectDTOCreateResponse {
    private Answer answer;

    public AnswerDTOCreateResponse(Answer answer) {
        super();
        this.answer=answer;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
