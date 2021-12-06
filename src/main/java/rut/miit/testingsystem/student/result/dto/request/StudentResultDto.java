package rut.miit.testingsystem.student.result.dto.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@EqualsAndHashCode(exclude = "answers")
public class StudentResultDto {

    private List<UUID> answers;

    private UUID testId;
}
