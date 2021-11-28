package rut.miit.testingsystem.student.group;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import rut.miit.testingsystem.IController;
import rut.miit.testingsystem.student.group.dto.request.StudentGroupDTOCreateRequest;
import rut.miit.testingsystem.student.group.dto.response.StudentGroupDTOCreateResponse;

import java.util.List;
import java.util.UUID;

public interface IStudentGroupController extends IController {
    @Override
    List<StudentGroup> findAll();

    @Override
    StudentGroup findById(UUID id);

    ResponseEntity<StudentGroupDTOCreateResponse> create(StudentGroupDTOCreateRequest createRequest);
}
