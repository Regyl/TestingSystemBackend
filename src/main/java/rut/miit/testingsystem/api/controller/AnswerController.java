package rut.miit.testingsystem.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import rut.miit.testingsystem.api.controller.interfaces.IAnswerController;
import rut.miit.testingsystem.entity.Answer;
import rut.miit.testingsystem.api.mapper.AnswerMapper;
import rut.miit.testingsystem.service.AnswerService;
import rut.miit.testingsystem.api.controller.dto.request.AnswerDto;
import rut.miit.testingsystem.api.controller.dto.response.AnswerDtoResponse;

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
    @Operation(summary = "Get answer by it's id")
    public AnswerDtoResponse findById(@PathVariable UUID id) {
        Answer answer = service.findById(id);
        return mapper.toDto(answer);
    }

    @GetMapping("/")
    @Operation(summary = "Get all answers")
    public List<AnswerDtoResponse> findAll() {
        return service.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete answer by id")
    public void deleteById(@PathVariable UUID id) {
        service.deleteById(id);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create new answer")
    public AnswerDtoResponse create(@RequestBody @Valid AnswerDto dto) {
        Answer answer = mapper.toEntity(dto);
        answer = service.save(answer);
        return mapper.toDto(answer);
    }

    @GetMapping("/question")
    @Operation(summary = "Get answers by specified question")
    public List<AnswerDtoResponse> findByQuestion(@RequestParam UUID id) {
        return service.findByQuestion(id).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
