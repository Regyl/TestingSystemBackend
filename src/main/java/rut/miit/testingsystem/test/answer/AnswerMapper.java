package rut.miit.testingsystem.test.answer;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import rut.miit.testingsystem.test.answer.dto.request.AnswerDTOCreateRequest;

@Component
public class AnswerMapper {
    private final ModelMapper mapper;

    public AnswerMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Answer toEntity(AnswerDTOCreateRequest createRequest) {

    }
}
