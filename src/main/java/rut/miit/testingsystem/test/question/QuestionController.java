package rut.miit.testingsystem.test.question;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rut.miit.testingsystem.test.question.dto.request.QuestionDto;
import rut.miit.testingsystem.test.question.dto.response.QuestionDtoResponse;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/questions")
public class QuestionController implements IQuestionController {
    private final QuestionService service;
    private final QuestionMapper mapper;

    public QuestionController(QuestionService service, QuestionMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/")
    public List<QuestionDtoResponse> findAll() {
        return service.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public QuestionDtoResponse findById(@PathVariable UUID id) {
        Question question = service.findById(id);
        return mapper.toDto(question);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        service.deleteById(id);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public QuestionDtoResponse create(@RequestBody @Valid QuestionDto dto) {
        Question question = mapper.toEntity(dto);
        question = service.create(question);
        return mapper.toDto(question);
    }

    @GetMapping("/test")
    public List<QuestionDtoResponse> findByTest(@RequestParam UUID id) {
        return service.findAllBYTest(id).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
