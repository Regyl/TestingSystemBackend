package rut.miit.testingsystem.subject;

import org.springframework.http.ResponseEntity;
import rut.miit.testingsystem.IController;
import rut.miit.testingsystem.subject.dto.request.SubjectDto;
import rut.miit.testingsystem.subject.dto.response.SubjectDTOResponse;

import java.util.List;
import java.util.UUID;

public interface ISubjectController extends IController {
    @Override
    List<SubjectDTOResponse> findAll();

    @Override
    SubjectDTOResponse findById(UUID id);

    ResponseEntity<SubjectDTOResponse> create(SubjectDto createRequest);
}
