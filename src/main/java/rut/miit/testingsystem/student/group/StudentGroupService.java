package rut.miit.testingsystem.student.group;

import org.springframework.stereotype.Service;
import rut.miit.testingsystem.exception.StudentGroupNotFoundException;
import rut.miit.testingsystem.student.group.dto.request.StudentGroupDto;

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
        return repository.findById(id).orElseThrow(StudentGroupNotFoundException::new);
    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }
}
