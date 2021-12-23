package rut.miit.testingsystem.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import rut.miit.testingsystem.api.controller.interfaces.ISubjectController;
import rut.miit.testingsystem.entity.Subject;
import rut.miit.testingsystem.api.mapper.SubjectMapper;
import rut.miit.testingsystem.service.SubjectService;
import rut.miit.testingsystem.api.controller.dto.request.SubjectDto;
import rut.miit.testingsystem.api.controller.dto.response.FacultyDtoResponse;
import rut.miit.testingsystem.api.controller.dto.response.SubjectDtoResponse;
import rut.miit.testingsystem.entity.enums.Faculty;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Tag(name = "Subjects")

@RestController
@RequestMapping("/subjects")
public class SubjectController implements ISubjectController {

    private final SubjectService service;
    private final SubjectMapper mapper;

    public SubjectController(SubjectService service, SubjectMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/")
    @Operation(summary = "Get all subjects")
    public List<SubjectDtoResponse> findAll() {
        return service.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get subject by id")
    public SubjectDtoResponse findById(@PathVariable UUID id) {
        Subject subject = service.findById(id);
        return mapper.toDto(subject);
    }

    @GetMapping("/faculties")
    @Operation(summary = "Get all subjects by specified faculty")
    public List<SubjectDtoResponse> findByFaculty(@RequestParam Faculty faculty) {
        return service.findByFaculty(faculty).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete subject by id")
    public void deleteById(@PathVariable UUID id) {
        service.deleteById(id);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create new subject")
    public SubjectDtoResponse create(@RequestBody @Valid SubjectDto dto) {
        Subject subject = mapper.toEntity(dto);
        subject = service.save(subject);
        return mapper.toDto(subject);
    }

    @GetMapping("/faculties/")
    @Operation
    public List<FacultyDtoResponse> getFaculties() {
        return Faculty.stream().
                map(FacultyDtoResponse::of)
                .collect(Collectors.toList());
    }
}
