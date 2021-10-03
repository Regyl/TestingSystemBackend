package rut.miit.testingsystem.student;

import rut.miit.testingsystem.student.dto.request.StudentDTOCreateRequest;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue
    @Column(unique = true)
    @NotNull
    private UUID id;

    @Column
    //@ManyToOne(optional = false, targetEntity = StudentGroup.class) //TODO: add
    private UUID groupId;

    @Column
    @NotNull
    private String firstName;

    @Column
    @NotNull
    private String secondName;

    @Column
    private String lastName; //отчество nullable

    @Column
    @NotNull
    private LocalDate birthDate;

    @Column
    @NotNull
    private Integer admissionYear;

    @Column(columnDefinition = "boolean default false")
    private Boolean isAgreed = false; //подтверждение кода с почты

    public Student() {}

    public Student(StudentDTOCreateRequest createRequest) {
        this.birthDate=createRequest.getBirthDate();
        this.firstName=createRequest.getFirstName();
        this.secondName=createRequest.getSecondName();
        this.lastName=createRequest.getLastName();
        this.admissionYear=createRequest.getAdmissionYear();
    }

    public Boolean getAgreed() {
        return isAgreed;
    }

    public void setAgreed(Boolean agreed) {
        isAgreed = agreed;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Integer getAdmissionYear() {
        return admissionYear;
    }

    public void setAdmissionYear(Integer admissionYear) {
        this.admissionYear = admissionYear;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public UUID getGroupId() {
        return groupId;
    }

    public void setGroupId(UUID groupId) {
        this.groupId = groupId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
