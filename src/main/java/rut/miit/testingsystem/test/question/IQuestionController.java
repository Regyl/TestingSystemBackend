package rut.miit.testingsystem.test.question;

import io.swagger.v3.oas.annotations.tags.Tag;
import rut.miit.testingsystem.IController;

import java.util.List;
import java.util.UUID;

@Tag(name = "Question")

public interface IQuestionController extends IController {
    @Override
    List<Question> findAll();

    @Override
    Question findById(UUID id);
}
