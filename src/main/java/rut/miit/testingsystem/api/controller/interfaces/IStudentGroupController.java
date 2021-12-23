package rut.miit.testingsystem.api.controller.interfaces;

import rut.miit.testingsystem.api.controller.dto.request.request.StudentGroupDto;
import rut.miit.testingsystem.api.controller.dto.response.response.StudentGroupDtoResponse;

import java.util.List;
import java.util.UUID;

public interface IStudentGroupController extends IController {
    @Override
    List<StudentGroupDtoResponse> findAll();

    @Override
    StudentGroupDtoResponse findById(UUID id);

    StudentGroupDtoResponse create(StudentGroupDto dto);
}
