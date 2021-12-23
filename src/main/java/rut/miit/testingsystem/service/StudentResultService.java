package rut.miit.testingsystem.service;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import rut.miit.testingsystem.entity.StudentResult;
import rut.miit.testingsystem.exception.EntityNotFoundException;
import rut.miit.testingsystem.exception.StudentResultNotFoundException;
import rut.miit.testingsystem.repository.StudentResultRepository;

import java.util.List;
import java.util.UUID;

@Service
public class StudentResultService {
    final StudentResultRepository repository;
    public StudentResultService(StudentResultRepository repository) {
        this.repository=repository;
    }

    public List<StudentResult> findAll() {
        return repository.findAll();
    }

    public StudentResult findById(UUID id) {
        return repository.findById(id).orElseThrow(StudentResultNotFoundException::new);
    }

    public void deleteById(UUID id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException(id, StudentResult.class);
        }
    }

    public StudentResult save(StudentResult result) {
        return repository.save(result);
    }
}
