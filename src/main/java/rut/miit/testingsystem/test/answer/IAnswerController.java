package rut.miit.testingsystem.test.answer;

import io.swagger.v3.oas.annotations.tags.Tag;
import rut.miit.testingsystem.IController;
import rut.miit.testingsystem.test.answer.dto.response.AnswerDtoResponse;

import java.util.List;
import java.util.UUID;

@Tag(name = "Answers")

public interface IAnswerController extends IController {
    @Override
    List<AnswerDtoResponse> findAll();

    @Override
    AnswerDtoResponse findById(UUID id);
}
