package rut.miit.testingsystem.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import rut.miit.testingsystem.api.controller.interfaces.IStudentController;
import rut.miit.testingsystem.entity.Student;
import rut.miit.testingsystem.api.mapper.StudentMapper;
import rut.miit.testingsystem.service.StudentService;
import rut.miit.testingsystem.api.controller.dto.request.request.StudentDto;
import rut.miit.testingsystem.api.controller.dto.request.request.StudentDtoGroupUpdateRequest;
import rut.miit.testingsystem.api.controller.dto.response.response.StudentDtoResponse;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Tag(name = "Students")

@RestController
@RequestMapping("/students")
public class StudentController implements IStudentController {

    private final StudentService service;
    private final StudentMapper mapper;

    public StudentController(StudentService service, StudentMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/")
    @Operation(summary = "Get all students")
    public List<StudentDtoResponse> findAll() {
        return service.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get student by id")
    public StudentDtoResponse findById(@PathVariable UUID id) {
        Student student = service.findById(id);
        return mapper.toDto(student);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create new student")
    public StudentDtoResponse create(@RequestBody @Valid StudentDto dto) {
        Student student = mapper.toEntity(dto);
        student = service.save(student);
        return mapper.toDto(student);
    }

    @PutMapping("/email")
    @Operation(summary = "Update user info after registration")
    public void postCreate(@RequestParam UUID studentId) {
        service.updateStatus(studentId);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete student by it's id")
    public void deleteById(@PathVariable UUID id) {
        service.deleteById(id);
    }

    @PutMapping("/group")
    @Operation(summary = "Add to student any group")
    public void updateStudentsGroup(@RequestBody @Valid StudentDtoGroupUpdateRequest groupUpdateRequest) {
        service.updateGroup(groupUpdateRequest);
    }
}
