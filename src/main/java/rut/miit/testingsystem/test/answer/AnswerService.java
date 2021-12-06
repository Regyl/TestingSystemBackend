package rut.miit.testingsystem.test.answer;

import org.springframework.stereotype.Service;
import rut.miit.testingsystem.exception.AnswerNotFoundException;
import rut.miit.testingsystem.test.answer.dto.request.AnswerDto;
import rut.miit.testingsystem.test.question.QuestionService;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AnswerService {

    private final AnswerRepository repository;

    public AnswerService(AnswerRepository repository) {
        this.repository = repository;
    }

    public Answer findById(UUID id) {
        return repository.findById(id).orElseThrow(AnswerNotFoundException::new);
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

    public double getResult(List<UUID> answerIds) {
        List<Answer> answers = findAllByIds(answerIds);
        answers = answers.stream().filter(Answer::getIsCorrect).collect(Collectors.toList());
        return answers.size() * 1.0 / answerIds.size();
    }
}
