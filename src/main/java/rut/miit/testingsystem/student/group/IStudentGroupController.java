package rut.miit.testingsystem.student.group;

import org.springframework.http.ResponseEntity;
import rut.miit.testingsystem.IController;
import rut.miit.testingsystem.student.group.dto.request.StudentGroupDTOCreateRequest;
import rut.miit.testingsystem.student.group.dto.response.StudentGroupDtoResponse;

import java.util.List;
import java.util.UUID;

public interface IStudentGroupController extends IController {
    @Override
    List<StudentGroup> findAll();

    @Override
    StudentGroup findById(UUID id);

    ResponseEntity<StudentGroupDtoResponse> create(StudentGroupDTOCreateRequest createRequest);
}
