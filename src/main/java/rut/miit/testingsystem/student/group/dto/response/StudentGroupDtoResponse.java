package rut.miit.testingsystem.student.group.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import rut.miit.testingsystem.AbstractDtoResponse;
import rut.miit.testingsystem.student.group.StudentGroup;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class StudentGroupDtoResponse extends AbstractDtoResponse {

    private StudentGroup group;

}
