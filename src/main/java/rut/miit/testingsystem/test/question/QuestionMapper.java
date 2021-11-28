package rut.miit.testingsystem.test.question;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import rut.miit.testingsystem.test.Test;
import rut.miit.testingsystem.test.TestService;
import rut.miit.testingsystem.test.question.dto.request.QuestionDto;
import rut.miit.testingsystem.test.question.dto.response.QuestionDtoResponse;

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
}
