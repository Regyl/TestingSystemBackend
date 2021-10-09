package rut.miit.testingsystem.student;

import lombok.Data;
import lombok.NoArgsConstructor;
import rut.miit.testingsystem.student.dto.request.StudentDTOCreateRequest;
import rut.miit.testingsystem.student.group.StudentGroup;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue
    @Column(unique = true)
    @NotNull
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private StudentGroup groupId;

    @NotNull
    private String firstName;

    @NotNull
    private String patronymic;

    private String lastName;

    @NotNull
    private LocalDate birthDate;

    @NotNull
    private Integer admissionYear;

    @Column(columnDefinition = "boolean default false")
    private Boolean isAgreed = false; //подтверждение кода с почты


    public Student(StudentDTOCreateRequest createRequest) {
        this.birthDate=createRequest.getBirthDate();
        this.firstName=createRequest.getFirstName();
        this.patronymic=createRequest.getPatronymic();
        this.lastName=createRequest.getLastName();
        this.admissionYear=createRequest.getAdmissionYear();
    }
}
