package rut.miit.testingsystem.api.controller.interfaces;

import rut.miit.testingsystem.api.controller.dto.response.QuestionDtoResponse;

import java.util.List;
import java.util.UUID;

public interface IQuestionController extends IController {
    @Override
    List<QuestionDtoResponse> findAll();

    @Override
    QuestionDtoResponse findById(UUID id);
}
