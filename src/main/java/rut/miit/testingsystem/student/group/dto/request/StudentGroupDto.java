package rut.miit.testingsystem.student.group.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class StudentGroupDto {
    @NotNull
    private String shortName;

    @NotNull
    private Integer number;
}
