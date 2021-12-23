package rut.miit.testingsystem.api.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import rut.miit.testingsystem.entity.Answer;
import rut.miit.testingsystem.api.controller.dto.request.AnswerDto;
import rut.miit.testingsystem.api.controller.dto.response.AnswerDtoResponse;
import rut.miit.testingsystem.entity.Question;
import rut.miit.testingsystem.service.QuestionService;

@Component
public class AnswerMapper {
    private final ModelMapper mapper;
    private final QuestionService questionService;

    public AnswerMapper(ModelMapper mapper, QuestionService questionService) {
        this.mapper = mapper;
        this.questionService = questionService;
    }

    public Answer toEntity(AnswerDto dto) {
        Answer answer = mapper.map(dto, Answer.class);
        Question question = questionService.findById(dto.getQuestionId());
        answer.setQuestion(question);
        return answer;
    }

    public AnswerDtoResponse toDto(Answer answer) {
        return mapper.map(answer, AnswerDtoResponse.class);
    }
}
