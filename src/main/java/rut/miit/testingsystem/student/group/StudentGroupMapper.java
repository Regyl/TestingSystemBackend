package rut.miit.testingsystem.student.group;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import rut.miit.testingsystem.student.group.dto.request.StudentGroupDto;
import rut.miit.testingsystem.student.group.dto.response.StudentGroupDtoResponse;

@Component
public class StudentGroupMapper {

    private final ModelMapper mapper;

    public StudentGroupMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public StudentGroup toEntity(StudentGroupDto dto) {
        return mapper.map(dto, StudentGroup.class);
    }

    public StudentGroupDtoResponse toDto(StudentGroup studentGroup) {
        return mapper.map(studentGroup, StudentGroupDtoResponse.class);
    }
}
