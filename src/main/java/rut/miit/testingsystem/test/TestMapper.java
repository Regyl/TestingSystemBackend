package rut.miit.testingsystem.test;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import rut.miit.testingsystem.subject.Subject;
import rut.miit.testingsystem.subject.SubjectService;
import rut.miit.testingsystem.test.dto.request.TestDto;
import rut.miit.testingsystem.test.dto.response.TestDtoResponse;

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
