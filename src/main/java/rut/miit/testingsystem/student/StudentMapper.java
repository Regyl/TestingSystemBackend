package rut.miit.testingsystem.student;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import rut.miit.testingsystem.auth.user.User;
import rut.miit.testingsystem.student.dto.request.StudentDto;
import rut.miit.testingsystem.student.dto.response.StudentDtoResponse;

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
