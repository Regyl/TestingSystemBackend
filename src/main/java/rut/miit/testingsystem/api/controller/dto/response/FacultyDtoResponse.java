package rut.miit.testingsystem.api.controller.dto.response;

import lombok.Data;
import rut.miit.testingsystem.entity.enums.Faculty;

@Data
public class FacultyDtoResponse {
    private String name;

    private String value;

    public static FacultyDtoResponse of(Faculty faculty) {
        FacultyDtoResponse response = new FacultyDtoResponse();
        response.name=faculty.name();
        response.value=faculty.getName();
        return response;
    }
}
