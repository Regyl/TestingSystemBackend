package rut.miit.testingsystem.subject.dto.response;

import rut.miit.testingsystem.ObjectDTOCreateResponse;
import rut.miit.testingsystem.subject.Subject;

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
