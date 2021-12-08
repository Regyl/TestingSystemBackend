package rut.miit.testingsystem.test.answer;

import rut.miit.testingsystem.IController;
import rut.miit.testingsystem.test.answer.dto.response.AnswerDtoResponse;

import java.util.List;
import java.util.UUID;

public interface IAnswerController extends IController {
    @Override
    List<AnswerDtoResponse> findAll();

    @Override
    AnswerDtoResponse findById(UUID id);
}
