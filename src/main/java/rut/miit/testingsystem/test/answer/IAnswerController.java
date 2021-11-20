package rut.miit.testingsystem.test.answer;

import io.swagger.v3.oas.annotations.tags.Tag;
import rut.miit.testingsystem.IController;

import java.util.List;
import java.util.UUID;

@Tag(name = "Answers")

public interface IAnswerController extends IController {
    @Override
    List<Answer> findAll();

    @Override
    Answer findById(UUID id);
}
