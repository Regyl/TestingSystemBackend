package rut.miit.testingsystem.student.result;

import rut.miit.testingsystem.IController;
import rut.miit.testingsystem.student.result.dto.response.StudentResultDtoResponse;

import java.util.List;
import java.util.UUID;

public interface IStudentResultController extends IController {
    @Override
    List<StudentResultDtoResponse> findAll();

    @Override
    StudentResultDtoResponse findById(UUID id);
}
