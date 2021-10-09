package rut.miit.testingsystem.student.result;

import rut.miit.testingsystem.IController;

import java.util.List;
import java.util.UUID;

public interface IStudentResultController extends IController {
    @Override
    List<StudentResult> findAll();

    @Override
    StudentResult findById(UUID id);
}
