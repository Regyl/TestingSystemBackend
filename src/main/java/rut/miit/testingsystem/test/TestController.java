package rut.miit.testingsystem.test;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import rut.miit.testingsystem.test.dto.request.TestDto;
import rut.miit.testingsystem.test.dto.response.TestDtoResponse;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Tag(name = "Tests")

@RestController
@RequestMapping("/tests")
public class TestController implements ITestController {
    private final TestService service;
    private final TestMapper mapper;

    public TestController(TestService service, TestMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/")
    public List<TestDtoResponse> findAll() {
        return service.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public TestDtoResponse findById(@PathVariable UUID id) {
        Test test = service.findById(id);
        return mapper.toDto(test);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        service.deleteById(id);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public TestDtoResponse create(@RequestBody @Valid TestDto dto) {
        Test test = mapper.toEntity(dto);
        test = service.create(test);
        return mapper.toDto(test);
    }

    @GetMapping("/subject")
    public List<TestDtoResponse> findAllBySubject(@RequestParam UUID id) {
        return service.findAllBySubject(id).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
