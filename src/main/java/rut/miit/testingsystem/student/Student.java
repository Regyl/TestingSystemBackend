package rut.miit.testingsystem.student;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import rut.miit.testingsystem.auth.user.User;
import rut.miit.testingsystem.student.dto.request.StudentDto;
import rut.miit.testingsystem.student.group.StudentGroup;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "student")
@Data
public class Student {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private StudentGroup group;

    @NotNull
    private String firstName;

    @NotNull
    private String patronymic;

    private String lastName;

    @NotNull
    private LocalDate birthDate;

    @NotNull
    private Integer admissionYear;

    @Column(columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean isAgreed = false; //подтверждение кода с почты

    @NotNull
    @OneToOne
    private User user;
}
