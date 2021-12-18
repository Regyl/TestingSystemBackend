package rut.miit.testingsystem.student.result;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import rut.miit.testingsystem.student.result.dto.request.StudentResultDto;
import rut.miit.testingsystem.student.result.dto.response.StudentResultDtoResponse;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Tag(name = "Student results")

@RestController
@RequestMapping("/students/results")
public class StudentResultController implements IStudentResultController {

    private final StudentResultService service;
    private final StudentResultMapper mapper;

    public StudentResultController(StudentResultService service, StudentResultMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/")
    @Operation(summary = "Get all results")
    public List<StudentResultDtoResponse> findAll() {
        return service.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get result by it's id")
    public StudentResultDtoResponse findById(@PathVariable UUID id) {
        StudentResult result = service.findById(id);
        return mapper.toDto(result);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete result by it's id")
    public void deleteById(@PathVariable UUID id) {
        service.deleteById(id);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Send student answers")
    public StudentResultDtoResponse save(@RequestBody @Valid StudentResultDto dto) {
        StudentResult result = mapper.toEntity(dto);
        result = service.save(result);
        return mapper.toDto(result);
    }


}
