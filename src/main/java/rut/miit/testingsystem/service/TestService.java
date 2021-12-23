package rut.miit.testingsystem.service;

import org.springframework.stereotype.Service;
import rut.miit.testingsystem.exception.EntityNotFoundException;
import rut.miit.testingsystem.repository.TestRepository;
import rut.miit.testingsystem.entity.Test;

import java.util.List;
import java.util.UUID;

@Service
public class TestService {

    private final TestRepository repository;

    public TestService(TestRepository repository) {
        this.repository=repository;
    }

    public List<Test> findAllBySubject(UUID subjectId) {
        return repository.findAllBySubjectId(subjectId);
    }

    public List<Test> findAll() {
        return repository.findAll();
    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    public Test create(Test test) {
        return repository.save(test);
    }

    public Test findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id, Test.class));
    }
}
