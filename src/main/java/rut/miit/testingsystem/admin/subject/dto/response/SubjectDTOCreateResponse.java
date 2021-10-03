package rut.miit.testingsystem.admin.subject.dto.response;

import rut.miit.testingsystem.ObjectDTOCreateResponse;
import rut.miit.testingsystem.admin.subject.Subject;

import java.time.LocalDateTime;

public class SubjectDTOCreateResponse extends ObjectDTOCreateResponse {
    private Subject subject;

    public SubjectDTOCreateResponse(Subject subject) {
        super();
        this.subject=subject;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
