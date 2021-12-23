package rut.miit.testingsystem.api.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import rut.miit.testingsystem.entity.Subject;
import rut.miit.testingsystem.service.SubjectService;
import rut.miit.testingsystem.entity.Test;
import rut.miit.testingsystem.api.controller.dto.request.TestDto;
import rut.miit.testingsystem.api.controller.dto.response.TestDtoResponse;

@Component
public class TestMapper {
    private final ModelMapper mapper;
    private final SubjectService subjectService;

    public TestMapper(ModelMapper mapper, SubjectService subjectService) {
        this.mapper = mapper;
        this.subjectService = subjectService;
    }

    public Test toEntity(TestDto dto) {
        Test test = mapper.map(dto, Test.class);
        Subject subject = subjectService.findById(dto.getSubjectId());
        test.setSubject(subject);
        return test;
    }

    public TestDtoResponse toDto(Test test) {
        return mapper.map(test, TestDtoResponse.class);
    }
}
