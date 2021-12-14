package rut.miit.testingsystem.test.question;

import rut.miit.testingsystem.IController;
import rut.miit.testingsystem.test.question.dto.response.QuestionDtoResponse;

import java.util.List;
import java.util.UUID;

public interface IQuestionController extends IController {
    @Override
    List<QuestionDtoResponse> findAll();

    @Override
    QuestionDtoResponse findById(UUID id);
}
