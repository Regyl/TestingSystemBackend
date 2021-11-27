package rut.miit.testingsystem.test.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rut.miit.testingsystem.exception.QuestionNotFoundException;
import rut.miit.testingsystem.test.TestService;
import rut.miit.testingsystem.test.question.dto.request.QuestionDTOCreateRequest;

import java.util.List;
import java.util.UUID;

@Service
public class QuestionService {
    private final QuestionRepository repository;
    public QuestionService(QuestionRepository repository) {
        this.repository=repository;
    }
    TestService testService;
    @Autowired
    public void setTestService(TestService testService) {
        this.testService = testService;
    }

    public Question findById(UUID id) {
        return repository.findById(id).orElseThrow(QuestionNotFoundException::new);
    }

    public List<Question> findAll() {
        return repository.findAll();
    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    public Question create(QuestionDTOCreateRequest createRequest) {
        return repository.save(new Question(createRequest, testService.findById(createRequest.getTestId())));
    }

    public List<Question> findAllBYTest(UUID id) {
        return repository.findAllByTestId(id);
    }
}
