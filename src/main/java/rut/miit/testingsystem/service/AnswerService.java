package rut.miit.testingsystem.service;

import org.springframework.stereotype.Service;
import rut.miit.testingsystem.entity.Answer;
import rut.miit.testingsystem.exception.EntityNotFoundException;
import rut.miit.testingsystem.repository.AnswerRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AnswerService {

    private final AnswerRepository repository;

    public AnswerService(AnswerRepository repository) {
        this.repository = repository;
    }

    public Answer findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id, Answer.class));
    }

    public List<Answer> findAll() {
        return repository.findAll();
    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    public Answer save(Answer answer) {
        return repository.save(answer);
    }

    public List<Answer> findByQuestion(UUID id) {
        return repository.findAllByQuestionId(id);
    }

    public List<Answer> findAllByIds(List<UUID> answerIds) {
        return repository.findAllById(answerIds);
    }

    //Counting result of test
    public double getResult(List<UUID> answerIds) {
        List<Answer> answers = findAllByIds(answerIds);
        answers = answers.stream().filter(Answer::getIsCorrect).collect(Collectors.toList());
        return answers.size() * 1.0 / answerIds.size();
    }
}
