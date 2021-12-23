package rut.miit.testingsystem.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import rut.miit.testingsystem.api.controller.interfaces.IQuestionController;
import rut.miit.testingsystem.api.mapper.QuestionMapper;
import rut.miit.testingsystem.entity.Question;
import rut.miit.testingsystem.service.QuestionService;
import rut.miit.testingsystem.api.controller.dto.request.QuestionDto;
import rut.miit.testingsystem.api.controller.dto.response.QuestionDtoResponse;
import rut.miit.testingsystem.api.controller.dto.response.QuestionDtoStudentResponse;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Tag(name = "Question")

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
    @Operation(summary = "Get all questions")
    public List<QuestionDtoResponse> findAll() {
        return service.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get question by id")
    public QuestionDtoResponse findById(@PathVariable UUID id) {
        Question question = service.findById(id);
        return mapper.toDto(question);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete question by id")
    public void deleteById(@PathVariable UUID id) {
        service.deleteById(id);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create new question")
    public QuestionDtoResponse create(@RequestBody @Valid QuestionDto dto) {
        Question question = mapper.toEntity(dto);
        question = service.save(question);
        return mapper.toDto(question);
    }

    @GetMapping("/test")
    @Operation(summary = "Get questions by specified test")
    public List<QuestionDtoResponse> findByTest(@RequestParam UUID id) {
        return service.findAllByTest(id).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/students/test")
    @Operation(summary = "Q&A for student requests (without isCorrect param in answer)")
    public List<QuestionDtoStudentResponse> findByTestForStudents(@RequestParam UUID id) {
        return service.findAllByTest(id).stream()
                .map(mapper::toStudentDto)
                .collect(Collectors.toList());
    }
}
