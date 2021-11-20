package rut.miit.testingsystem.subject;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import rut.miit.testingsystem.IController;
import rut.miit.testingsystem.subject.dto.request.SubjectDTOCreateRequest;
import rut.miit.testingsystem.subject.dto.response.SubjectDTOCreateResponse;

import java.util.List;
import java.util.UUID;

@Tag(name = "Subjects")

public interface ISubjectController extends IController {
    @Override
    List<Subject> findAll();

    @Override
    Subject findById(UUID id);

    ResponseEntity<SubjectDTOCreateResponse> create(SubjectDTOCreateRequest createRequest);
}
