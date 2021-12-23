package rut.miit.testingsystem.api.controller.dto.request;

import lombok.Data;
import rut.miit.testingsystem.entity.enums.Faculty;

import javax.validation.constraints.NotNull;

@Data
public class SubjectDto {
    @NotNull
    private String name;

    @NotNull
    private Faculty faculty;
}
