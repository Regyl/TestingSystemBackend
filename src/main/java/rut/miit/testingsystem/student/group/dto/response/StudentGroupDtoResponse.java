package rut.miit.testingsystem.student.group.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import rut.miit.testingsystem.AbstractDtoResponse;
import rut.miit.testingsystem.student.group.StudentGroup;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
public class StudentGroupDtoResponse extends AbstractDtoResponse {

    private UUID id;

    private String shortName;

    private Integer number;

}
