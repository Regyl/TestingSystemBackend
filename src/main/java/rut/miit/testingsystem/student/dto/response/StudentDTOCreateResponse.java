package rut.miit.testingsystem.student.dto.response;

import rut.miit.testingsystem.ObjectDTOCreateResponse;
import rut.miit.testingsystem.student.Student;

public class StudentDTOCreateResponse extends ObjectDTOCreateResponse {
    private Student student;

    private int accessCode;

    public StudentDTOCreateResponse(Student student) {
        super();
        this.student=student;
    }

    public int getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(int accessCode) {
        this.accessCode = accessCode;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
