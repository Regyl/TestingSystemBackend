package rut.miit.testingsystem.service;

import org.springframework.stereotype.Service;
import rut.miit.testingsystem.entity.StudentGroup;
import rut.miit.testingsystem.exception.EntityNotFoundException;
import rut.miit.testingsystem.repository.StudentGroupRepository;

import java.util.List;
import java.util.UUID;

@Service
public class StudentGroupService {

    private final StudentGroupRepository repository;

    public StudentGroupService(StudentGroupRepository repository) {
        this.repository=repository;
    }

    public StudentGroup save(StudentGroup studentGroup) {
        return repository.save(studentGroup);
    }

    public List<StudentGroup> findAll() {
        return repository.findAll();
    }

    public StudentGroup findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id, StudentGroup.class));
    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
}
