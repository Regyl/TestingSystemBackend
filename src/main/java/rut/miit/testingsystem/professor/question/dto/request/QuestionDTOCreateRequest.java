package rut.miit.testingsystem.professor.question.dto.request;

import javax.validation.constraints.NotNull;

public class QuestionDTOCreateRequest {
    @NotNull
    private String text;

    private String additionalInfo;

    public QuestionDTOCreateRequest() {}

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
