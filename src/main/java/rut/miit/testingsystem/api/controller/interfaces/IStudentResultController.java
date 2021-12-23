package rut.miit.testingsystem.api.controller.interfaces;

import rut.miit.testingsystem.api.controller.dto.response.StudentResultDtoResponse;

import java.util.List;
import java.util.UUID;

public interface IStudentResultController extends IController {
    @Override
    List<StudentResultDtoResponse> findAll();

    @Override
    StudentResultDtoResponse findById(UUID id);
}
