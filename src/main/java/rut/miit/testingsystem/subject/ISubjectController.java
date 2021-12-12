package rut.miit.testingsystem.subject;

import org.springframework.http.ResponseEntity;
import rut.miit.testingsystem.IController;
import rut.miit.testingsystem.subject.dto.request.SubjectDto;
import rut.miit.testingsystem.subject.dto.response.SubjectDtoResponse;

import java.util.List;
import java.util.UUID;

public interface ISubjectController extends IController {
    @Override
    List<SubjectDtoResponse> findAll();

    @Override
    SubjectDtoResponse findById(UUID id);

    SubjectDtoResponse create(SubjectDto createRequest);
}
