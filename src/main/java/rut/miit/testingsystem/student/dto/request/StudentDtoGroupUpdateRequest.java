package rut.miit.testingsystem.student.dto.request;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StudentDtoGroupUpdateRequest {
    private UUID groupId;

    private List<UUID> studentIds;

    public StudentDtoGroupUpdateRequest() {}

    public List<UUID> getStudentIds() {
        if(this.studentIds==null)
            this.studentIds = new ArrayList<>();
        return studentIds;
    }

    public void setStudentIds(List<UUID> studentIds) {
        this.studentIds = studentIds;
    }

    public UUID getGroupId() {
        return groupId;
    }

    public void setGroupId(UUID groupId) {
        this.groupId = groupId;
    }
}
