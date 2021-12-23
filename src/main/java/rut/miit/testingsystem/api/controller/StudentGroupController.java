package rut.miit.testingsystem.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import rut.miit.testingsystem.api.controller.interfaces.IStudentGroupController;
import rut.miit.testingsystem.entity.StudentGroup;
import rut.miit.testingsystem.api.mapper.StudentGroupMapper;
import rut.miit.testingsystem.service.StudentGroupService;
import rut.miit.testingsystem.api.controller.dto.request.request.StudentGroupDto;
import rut.miit.testingsystem.api.controller.dto.response.response.StudentGroupDtoResponse;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Tag(name = "Student groups")

@RestController
@RequestMapping("/students/groups")
public class StudentGroupController implements IStudentGroupController {

    private final StudentGroupService service;
    private final StudentGroupMapper mapper;

    public StudentGroupController(StudentGroupService service, StudentGroupMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create new group")
    public StudentGroupDtoResponse create(@RequestBody @Valid StudentGroupDto dto) {
        StudentGroup group = mapper.toEntity(dto);
        group = service.save(group);
        return mapper.toDto(group);
    }

    @GetMapping("/")
    @Operation(summary = "All groups")
    public List<StudentGroupDtoResponse> findAll() {
        return service.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find particular student group")
    public StudentGroupDtoResponse findById(@PathVariable UUID id) {
        StudentGroup group = service.findById(id);
        return mapper.toDto(group);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete student group by it's id")
    public void deleteById(@PathVariable UUID id) {
        service.deleteById(id);
    }
}
