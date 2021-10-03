package rut.miit.testingsystem.studentgroup;

import org.springframework.stereotype.Service;
import rut.miit.testingsystem.exception.StudentGroupNotFoundException;
import rut.miit.testingsystem.studentgroup.dto.request.StudentGroupDTOCreateRequest;

import java.util.List;
import java.util.UUID;

@Service
public class StudentGroupService {
    StudentGroupRepository repository;
    public StudentGroupService(StudentGroupRepository repository) {
        this.repository=repository;
    }

    public StudentGroup save(StudentGroupDTOCreateRequest createRequest) {
        return repository.save(new StudentGroup(createRequest));
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
