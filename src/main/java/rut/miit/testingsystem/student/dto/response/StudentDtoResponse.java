package rut.miit.testingsystem.student.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import rut.miit.testingsystem.AbstractDtoResponse;
import rut.miit.testingsystem.auth.user.User;
import rut.miit.testingsystem.student.group.StudentGroup;

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