package rut.miit.testingsystem.student.result;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import rut.miit.testingsystem.student.result.dto.request.StudentResultDto;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

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
    public List<StudentResult> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public StudentResult findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        //TODO:
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Send student answers")
    public void save(@RequestBody @Valid StudentResultDto dto) {
        StudentResult result = mapper.toEntity(dto);
        service.save(result);
    }


}
