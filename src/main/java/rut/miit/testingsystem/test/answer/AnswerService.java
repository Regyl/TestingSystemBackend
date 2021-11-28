package rut.miit.testingsystem.test.answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rut.miit.testingsystem.exception.AnswerNotFoundException;
import rut.miit.testingsystem.test.answer.dto.request.AnswerDTOCreateRequest;
import rut.miit.testingsystem.test.question.QuestionService;

import java.util.List;
import java.util.UUID;

@Service
public class AnswerService {
    private final AnswerRepository repository;
    private final QuestionService questionService;

    public AnswerService(AnswerRepository repository, QuestionService questionService) {
        this.repository = repository;
        this.questionService = questionService;
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

    public Answer create(AnswerDTOCreateRequest createRequest) {
        return repository.save(new Answer(createRequest, questionService.findById(createRequest.getQuestionId())));
    }

    public List<Answer> findByQuestion(UUID id) {
        return repository.findAllByQuestionId(id);
    }
}
