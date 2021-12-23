package rut.miit.testingsystem.api.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import rut.miit.testingsystem.entity.Student;
import rut.miit.testingsystem.entity.User;
import rut.miit.testingsystem.api.controller.dto.request.request.StudentDto;
import rut.miit.testingsystem.api.controller.dto.response.response.StudentDtoResponse;

@Component
public class StudentMapper {

    private final ModelMapper mapper;

    public StudentMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Student toEntity(StudentDto dto) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Student student = mapper.map(dto, Student.class);
        student.setUser(user);
        return student;
    }

    public StudentDtoResponse toDto(Student student) {
        return mapper.map(student, StudentDtoResponse.class);
    }
}
