package rut.miit.testingsystem.student.group;

import rut.miit.testingsystem.IController;
import rut.miit.testingsystem.student.group.dto.request.StudentGroupDto;
import rut.miit.testingsystem.student.group.dto.response.StudentGroupDtoResponse;

import java.util.List;
import java.util.UUID;

public interface IStudentGroupController extends IController {
    @Override
    List<StudentGroupDtoResponse> findAll();

    @Override
    StudentGroupDtoResponse findById(UUID id);

    StudentGroupDtoResponse create(StudentGroupDto dto);
}
