package rut.miit.testingsystem.api.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import rut.miit.testingsystem.entity.StudentGroup;
import rut.miit.testingsystem.api.controller.dto.request.request.StudentGroupDto;
import rut.miit.testingsystem.api.controller.dto.response.response.StudentGroupDtoResponse;

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
