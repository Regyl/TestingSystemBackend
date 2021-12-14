package rut.miit.testingsystem.student;

import rut.miit.testingsystem.IController;
import rut.miit.testingsystem.student.dto.response.StudentDtoResponse;

import java.util.List;
import java.util.UUID;

public interface IStudentController extends IController {
    @Override
    List<StudentDtoResponse> findAll();

    @Override
    StudentDtoResponse findById(UUID id);


}
