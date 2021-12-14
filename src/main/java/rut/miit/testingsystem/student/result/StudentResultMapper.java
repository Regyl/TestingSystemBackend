package rut.miit.testingsystem.student.result;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import rut.miit.testingsystem.auth.user.User;
import rut.miit.testingsystem.student.Student;
import rut.miit.testingsystem.student.StudentService;
import rut.miit.testingsystem.student.result.dto.request.StudentResultDto;
import rut.miit.testingsystem.student.result.dto.response.StudentResultDtoResponse;
import rut.miit.testingsystem.test.Test;
import rut.miit.testingsystem.test.TestService;
import rut.miit.testingsystem.test.answer.AnswerService;

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
