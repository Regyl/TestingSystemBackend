package rut.miit.testingsystem.service;

import org.springframework.stereotype.Service;
import rut.miit.testingsystem.entity.Subject;
import rut.miit.testingsystem.exception.EntityNotFoundException;
import rut.miit.testingsystem.repository.SubjectRepository;
import rut.miit.testingsystem.entity.enums.Faculty;

import java.util.List;
import java.util.UUID;

@Service
public class SubjectService {

    private final SubjectRepository repository;

    public SubjectService(SubjectRepository repository) {
        this.repository=repository;
    }

    public List<Subject> findAll() {
        return repository.findAll();
    }

    public List<Subject> findByFaculty(Faculty faculty) {
        return repository.findAllByFaculty(faculty);
    }

    public Subject findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id, Subject.class));
    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    public Subject save(Subject subject) {
        return repository.save(subject);
    }
}
