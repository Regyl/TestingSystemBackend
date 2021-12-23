package rut.miit.testingsystem.api.controller.interfaces;

import rut.miit.testingsystem.api.controller.dto.response.TestDtoResponse;

import java.util.List;
import java.util.UUID;

public interface ITestController extends IController {
    @Override
    List<TestDtoResponse> findAll();

    @Override
    TestDtoResponse findById(UUID id);
}
