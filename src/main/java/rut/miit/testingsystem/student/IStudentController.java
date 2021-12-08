package rut.miit.testingsystem.student;

import rut.miit.testingsystem.IController;

import java.util.List;
import java.util.UUID;

public interface IStudentController extends IController {
    @Override
    List<Student> findAll();

    @Override
    Student findById(UUID id);


}
