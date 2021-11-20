package rut.miit.testingsystem.test;

import io.swagger.v3.oas.annotations.tags.Tag;
import rut.miit.testingsystem.IController;

import java.util.List;
import java.util.UUID;

@Tag(name = "Tests")

public interface ITestController extends IController {
    @Override
    List<Test> findAll();

    @Override
    Test findById(UUID id);
}
