package rut.miit.testingsystem.subject.dto.response;

import lombok.Data;
import rut.miit.testingsystem.ObjectDTOCreateResponse;
import rut.miit.testingsystem.subject.Subject;

@Data
public class SubjectDTOCreateResponse extends ObjectDTOCreateResponse {
    private Subject subject;

    public SubjectDTOCreateResponse(Subject subject) {
        super();
        this.subject=subject;
    }
}
