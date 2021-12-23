package rut.miit.testingsystem.api.controller.dto.response.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import rut.miit.testingsystem.api.controller.dto.response.AbstractDtoResponse;
import rut.miit.testingsystem.entity.User;
import rut.miit.testingsystem.entity.StudentGroup;

import java.time.LocalDate;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
public class StudentDtoResponse extends AbstractDtoResponse {

    private UUID id;

    private StudentGroup group;

    private String firstName;

    private String patronymic;

    private String lastName;

    private LocalDate birthDate;

    private Integer admissionYear;

    private Boolean isAgreed; //подтверждение кода с почты

    private User user;
}
