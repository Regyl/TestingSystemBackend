package rut.miit.testingsystem.test.question;

import rut.miit.testingsystem.IController;

import java.util.List;
import java.util.UUID;

public interface IQuestionController extends IController {
    @Override
    public List<Question> findAll();

    @Override
    public Question findById(UUID id);
}
