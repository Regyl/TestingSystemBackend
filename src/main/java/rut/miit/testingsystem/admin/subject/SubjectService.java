package rut.miit.testingsystem.admin.subject;

import org.springframework.stereotype.Service;
import rut.miit.testingsystem.exception.SubjectNotFoundException;
import rut.miit.testingsystem.admin.subject.dto.request.SubjectDTOCreateRequest;

import java.util.List;
import java.util.UUID;

@Service
public class SubjectService {
    final SubjectRepository repository;
    public SubjectService(SubjectRepository repository) {
        this.repository=repository;
    }

    public List<Subject> findAll() {
        return repository.findAll();
    }

    public Subject findById(UUID id) {
        return repository.findById(id).orElseThrow(SubjectNotFoundException::new);
    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    public Subject create(SubjectDTOCreateRequest createRequest) {
        return repository.save(new Subject(createRequest));
    }
}
