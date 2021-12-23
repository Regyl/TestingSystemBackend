package rut.miit.testingsystem.service;

import org.springframework.stereotype.Service;
import rut.miit.testingsystem.exception.EntityNotFoundException;
import rut.miit.testingsystem.repository.QuestionRepository;
import rut.miit.testingsystem.entity.Question;

import java.util.List;
import java.util.UUID;

@Service
public class QuestionService {

    private final QuestionRepository repository;

    public QuestionService(QuestionRepository repository) {
        this.repository=repository;
    }

    public Question findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id, Question.class));
    }

    public List<Question> findAll() {
        return repository.findAll();
    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    public Question save(Question question) {
        return repository.save(question);
    }

    public List<Question> findAllByTest(UUID id) {
        return repository.findAllByTestId(id);
    }
}
