package rut.miit.testingsystem.student.dto.request;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class StudentDTOCreateRequest {
    @NotNull
    private String firstName;

    @NotNull
    private String secondName;

    private String lastName;

    @NotNull
    private LocalDate birthDate;

    @NotNull
    private Integer admissionYear;

    public StudentDTOCreateRequest() {}

    public Integer getAdmissionYear() {
        return admissionYear;
    }

    public void setAdmissionYear(Integer admissionYear) {
        this.admissionYear = admissionYear;
    }

    public LocalDate getBirthDate() {
        return birthDate;
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
}
