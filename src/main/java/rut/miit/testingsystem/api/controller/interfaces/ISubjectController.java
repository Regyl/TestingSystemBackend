package rut.miit.testingsystem.api.controller.interfaces;

import rut.miit.testingsystem.api.controller.dto.request.SubjectDto;
import rut.miit.testingsystem.api.controller.dto.response.SubjectDtoResponse;

import java.util.List;
import java.util.UUID;

public interface ISubjectController extends IController {
    @Override
    List<SubjectDtoResponse> findAll();

    @Override
    SubjectDtoResponse findById(UUID id);

    SubjectDtoResponse create(SubjectDto createRequest);
}
