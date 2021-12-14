package rut.miit.testingsystem.subject;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import rut.miit.testingsystem.subject.dto.request.SubjectDto;
import rut.miit.testingsystem.subject.dto.response.FacultyDtoResponse;
import rut.miit.testingsystem.subject.dto.response.SubjectDtoResponse;

@Component
public class SubjectMapper {

    private final ModelMapper mapper;

    public SubjectMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Subject toEntity(SubjectDto dto) {
        return mapper.map(dto, Subject.class);
    }

    public SubjectDtoResponse toDto(Subject subject) {
        SubjectDtoResponse response = mapper.map(subject, SubjectDtoResponse.class);
        response.setFaculty(FacultyDtoResponse.of(subject.getFaculty()));
        return response;
    }
}
