package rut.miit.testingsystem.subject.dto.response;

import lombok.Data;
import rut.miit.testingsystem.subject.faculty.Faculty;

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
