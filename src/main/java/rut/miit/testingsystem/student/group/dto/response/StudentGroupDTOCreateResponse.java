package rut.miit.testingsystem.student.group.dto.response;

import rut.miit.testingsystem.ObjectDTOCreateResponse;
import rut.miit.testingsystem.student.group.StudentGroup;

public class StudentGroupDTOCreateResponse extends ObjectDTOCreateResponse {
    private StudentGroup group;

    public StudentGroupDTOCreateResponse(StudentGroup group) {
        super();
        this.group=group;
    }

    public StudentGroup getGroup() {
        return group;
    }

    public void setGroup(StudentGroup group) {
        this.group = group;
    }
}
