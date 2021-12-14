package rut.miit.testingsystem.test.answer;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import rut.miit.testingsystem.test.answer.dto.request.AnswerDto;
import rut.miit.testingsystem.test.answer.dto.response.AnswerDtoResponse;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Tag(name = "Answers")

@RestController
@RequestMapping("/answers")
public class AnswerController implements IAnswerController {

    private final AnswerService service;
    private final AnswerMapper mapper;

    public AnswerController(AnswerService service, AnswerMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/{id}")
    public AnswerDtoResponse findById(@PathVariable UUID id) {
        Answer answer = service.findById(id);
        return mapper.toDto(answer);
    }

    @GetMapping("/")
    public List<AnswerDtoResponse> findAll() {
        return service.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        service.deleteById(id);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public AnswerDtoResponse create(@RequestBody @Valid AnswerDto dto) {
        Answer answer = mapper.toEntity(dto);
        answer = service.save(answer);
        return mapper.toDto(answer);
    }

    @GetMapping("/question")
    public List<AnswerDtoResponse> findByQuestion(@RequestParam UUID id) {
        return service.findByQuestion(id).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
