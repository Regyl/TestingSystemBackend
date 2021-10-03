package rut.miit.testingsystem.admin.studentgroup;

import org.springframework.http.ResponseEntity;
import rut.miit.testingsystem.IController;
import rut.miit.testingsystem.admin.studentgroup.dto.request.StudentGroupDTOCreateRequest;
import rut.miit.testingsystem.admin.studentgroup.dto.response.StudentGroupDTOCreateResponse;

import java.util.List;
import java.util.UUID;

public interface IStudentGroupController extends IController {
    @Override
    public List<StudentGroup> findAll();

    @Override
    public StudentGroup findById(UUID id);

    ResponseEntity<StudentGroupDTOCreateResponse> create(StudentGroupDTOCreateRequest createRequest);
}
