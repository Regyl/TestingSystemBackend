package rut.miit.testingsystem.api.controller.interfaces;

import rut.miit.testingsystem.api.controller.dto.response.AnswerDtoResponse;

import java.util.List;
import java.util.UUID;

public interface IAnswerController extends IController {
    @Override
    List<AnswerDtoResponse> findAll();

    @Override
    AnswerDtoResponse findById(UUID id);
}
