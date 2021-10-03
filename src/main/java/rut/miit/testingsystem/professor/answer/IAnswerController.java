package rut.miit.testingsystem.professor.answer;

import rut.miit.testingsystem.IController;

import java.util.List;
import java.util.UUID;

public interface IAnswerController extends IController {
    @Override
    public List<Answer> findAll();

    @Override
    public Answer findById(UUID id);
}
