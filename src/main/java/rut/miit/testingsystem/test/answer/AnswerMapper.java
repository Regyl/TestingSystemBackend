package rut.miit.testingsystem.test.answer;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import rut.miit.testingsystem.test.answer.dto.request.AnswerDto;
import rut.miit.testingsystem.test.answer.dto.response.AnswerDtoResponse;
import rut.miit.testingsystem.test.answer.dto.response.AnswerDtoStudentResponse;
import rut.miit.testingsystem.test.question.Question;
import rut.miit.testingsystem.test.question.QuestionService;

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
