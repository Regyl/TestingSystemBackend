package rut.miit.testingsystem.test;

import rut.miit.testingsystem.IController;
import rut.miit.testingsystem.test.dto.response.TestDtoResponse;

import java.util.List;
import java.util.UUID;

public interface ITestController extends IController {
    @Override
    List<TestDtoResponse> findAll();

    @Override
    TestDtoResponse findById(UUID id);
}
