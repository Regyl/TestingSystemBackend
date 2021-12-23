package rut.miit.testingsystem.api.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import rut.miit.testingsystem.entity.Test;
import rut.miit.testingsystem.service.TestService;
import rut.miit.testingsystem.entity.Question;
import rut.miit.testingsystem.api.controller.dto.request.QuestionDto;
import rut.miit.testingsystem.api.controller.dto.response.QuestionDtoResponse;
import rut.miit.testingsystem.api.controller.dto.response.QuestionDtoStudentResponse;

@Component
public class QuestionMapper {
    private final ModelMapper mapper;
    private final TestService testService;

    public QuestionMapper(ModelMapper mapper, TestService testService) {
        this.mapper = mapper;
        this.testService = testService;
    }

    public Question toEntity(QuestionDto dto) {
        Question question = mapper.map(dto, Question.class);
        Test test = testService.findById(dto.getTestId());
        question.setTest(test);
        return question;
    }

    public QuestionDtoResponse toDto(Question question) {
        return mapper.map(question, QuestionDtoResponse.class);
    }

    public QuestionDtoStudentResponse toStudentDto(Question question) {
        return mapper.map(question, QuestionDtoStudentResponse.class);
    }

}
