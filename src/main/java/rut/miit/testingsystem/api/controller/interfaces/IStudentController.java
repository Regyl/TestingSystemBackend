package rut.miit.testingsystem.api.controller.interfaces;

import rut.miit.testingsystem.api.controller.dto.response.response.StudentDtoResponse;

import java.util.List;
import java.util.UUID;

public interface IStudentController extends IController {
    @Override
    List<StudentDtoResponse> findAll();

    @Override
    StudentDtoResponse findById(UUID id);


}
