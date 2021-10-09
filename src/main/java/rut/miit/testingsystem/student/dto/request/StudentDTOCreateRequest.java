package rut.miit.testingsystem.student.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class StudentDTOCreateRequest {
    @NotNull
    private String firstName;

    @NotNull
    private String patronymic;

    private String lastName;

    @NotNull
    private LocalDate birthDate;

    @NotNull
    private Integer admissionYear;
}
