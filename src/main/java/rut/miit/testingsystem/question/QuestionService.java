package rut.miit.testingsystem.question;

import org.springframework.stereotype.Service;
import rut.miit.testingsystem.exception.QuestionNotFoundException;
import rut.miit.testingsystem.question.dto.request.QuestionDTOCreateRequest;

import java.util.List;
import java.util.UUID;

@Service
public class QuestionService {
    final QuestionRepository repository;
    public QuestionService(QuestionRepository repository) {
        this.repository=repository;
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
        return repository.save(new Question(createRequest));
    }
}
