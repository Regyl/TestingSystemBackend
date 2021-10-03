package rut.miit.testingsystem.student;

import rut.miit.testingsystem.IController;

import java.util.List;
import java.util.UUID;

public interface IStudentController extends IController {
    @Override
    public List<Student> findAll();

    @Override
    public Student findById(UUID id);


}
