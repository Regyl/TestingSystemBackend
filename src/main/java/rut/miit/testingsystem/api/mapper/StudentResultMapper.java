package rut.miit.testingsystem.api.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import rut.miit.testingsystem.entity.StudentResult;
import rut.miit.testingsystem.entity.User;
import rut.miit.testingsystem.entity.Student;
import rut.miit.testingsystem.service.StudentService;
import rut.miit.testingsystem.api.controller.dto.request.request.StudentResultDto;
import rut.miit.testingsystem.api.controller.dto.response.StudentResultDtoResponse;
import rut.miit.testingsystem.entity.Test;
import rut.miit.testingsystem.service.TestService;
import rut.miit.testingsystem.service.AnswerService;

@Component
public class StudentResultMapper {

    private final ModelMapper mapper;
    private final StudentService studentService;
    private final TestService testService;
    private final AnswerService answerService;

    public StudentResultMapper(ModelMapper mapper, StudentService studentService, TestService testService, AnswerService answerService) {
        this.mapper = mapper;
        this.studentService = studentService;
        this.testService = testService;
        this.answerService = answerService;
    }

    public StudentResult toEntity(StudentResultDto dto) {
        StudentResult result = new StudentResult();
        Test test = testService.findById(dto.getTestId());
        result.setTest(test);
        Student student = studentService.findByUser(getAuthenticatedUser());
        result.setStudent(student);
        result.setResultScore(answerService.getResult(dto.getAnswers()));
        return result;
    }

    public StudentResultDtoResponse toDto(StudentResult result) {
        return mapper.map(result, StudentResultDtoResponse.class);
    }

    public User getAuthenticatedUser() {
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
