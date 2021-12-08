package rut.miit.testingsystem.student.dto.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Data
public class StudentDtoGroupUpdateRequest {

    @NotNull
    private UUID groupId;

    @NotNull
    private List<UUID> studentIds;

}
