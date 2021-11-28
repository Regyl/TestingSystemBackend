package rut.miit.testingsystem.test.question;

import io.swagger.v3.oas.annotations.tags.Tag;
import rut.miit.testingsystem.IController;
import rut.miit.testingsystem.test.question.dto.response.QuestionDtoResponse;

import java.util.List;
import java.util.UUID;

@Tag(name = "Question")

public interface IQuestionController extends IController {
    @Override
    List<QuestionDtoResponse> findAll();

    @Override
    QuestionDtoResponse findById(UUID id);
}
