package rut.miit.testingsystem.admin.subject;

import org.springframework.http.ResponseEntity;
import rut.miit.testingsystem.IController;
import rut.miit.testingsystem.admin.subject.dto.request.SubjectDTOCreateRequest;
import rut.miit.testingsystem.admin.subject.dto.response.SubjectDTOCreateResponse;

import java.util.List;
import java.util.UUID;

public interface ISubjectController extends IController {
    @Override
    public List<Subject> findAll();

    @Override
    public Subject findById(UUID id);


    public ResponseEntity<SubjectDTOCreateResponse> create(SubjectDTOCreateRequest createRequest);
}
