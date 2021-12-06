package rut.miit.testingsystem.student.result;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import rut.miit.testingsystem.student.StudentService;
import rut.miit.testingsystem.student.result.dto.request.StudentResultDto;
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
//        result.setStudent(); //TODO: get student id from SecurityHolder
        result.setResultScore(answerService.getResult(dto.getAnswers()));
        return result;
    }
}
