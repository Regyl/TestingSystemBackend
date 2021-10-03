package rut.miit.testingsystem.admin.subject.dto.request;

import javax.validation.constraints.NotNull;

public class SubjectDTOCreateRequest {
    @NotNull
    private String name;

    public SubjectDTOCreateRequest() {}

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name=name;
    }
}
