package rut.miit.testingsystem.student.result;

import org.springframework.stereotype.Service;
import rut.miit.testingsystem.exception.StudentResultNotFoundException;

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
        repository.deleteById(id);
    }

    public StudentResult save(StudentResult result) {
        return repository.save(result);
    }
}
