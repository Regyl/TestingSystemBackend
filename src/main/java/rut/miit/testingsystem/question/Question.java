package rut.miit.testingsystem.question;

import rut.miit.testingsystem.question.dto.request.QuestionDTOCreateRequest;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue
    @Column
    @NotNull
    private UUID id;

    @Column
    @NotNull
    @Lob //important: for type text
    private String text;

    @Column
    @Lob
    private String additionalInfo;

    public Question() {}

    public Question(QuestionDTOCreateRequest createRequest) {
        this.text= createRequest.getText();
        this.additionalInfo= createRequest.getAdditionalInfo();
    }

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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
