package rut.miit.testingsystem.studentgroup.dto.request;

import javax.validation.constraints.NotNull;

public class StudentGroupDTOCreateRequest {
    @NotNull
    private String shortName;

    @NotNull
    private Integer number;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
