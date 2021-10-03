package rut.miit.testingsystem.professor.test;

import rut.miit.testingsystem.IController;

import java.util.List;
import java.util.UUID;

public interface ITestController extends IController {
    @Override
    public List<Test> findAll();

    @Override
    public Test findById(UUID id);
}
