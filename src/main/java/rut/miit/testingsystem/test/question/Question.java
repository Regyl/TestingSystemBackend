package rut.miit.testingsystem.test.question;

import lombok.Data;
import lombok.NoArgsConstructor;
import rut.miit.testingsystem.test.Test;
import rut.miit.testingsystem.test.question.dto.request.QuestionDTOCreateRequest;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "question")
@Data
@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue
    private UUID id;

    @NotNull
    @Column(columnDefinition = "TEXT")
    private String text;

    @Column(columnDefinition = "TEXT")
    private String additionalInfo;

    @ManyToOne
    @JoinColumn(name = "test_id")
    @NotNull
    private Test test;

    public Question(QuestionDTOCreateRequest createRequest, Test test) {
        this.text= createRequest.getText();
        this.additionalInfo= createRequest.getAdditionalInfo();
        this.test=test;
    }
}
