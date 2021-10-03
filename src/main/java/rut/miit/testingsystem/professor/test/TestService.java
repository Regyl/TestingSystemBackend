package rut.miit.testingsystem.professor.test;

import org.springframework.stereotype.Service;
import rut.miit.testingsystem.exception.TestNotFoundException;
import rut.miit.testingsystem.professor.test.dto.request.TestDTOCreateRequest;

import java.util.List;
import java.util.UUID;

@Service
public class TestService {
    final TestRepository repository;
    public TestService(TestRepository repository) {
        this.repository=repository;
    }

    public List<Test> findAll() {
        return repository.findAll();
    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    public Test create(TestDTOCreateRequest createRequest) {
        return repository.save(new Test(createRequest));
    }

    public Test findById(UUID id) {
        return repository.findById(id).orElseThrow(TestNotFoundException::new);
    }
}
