package rut.miit.testingsystem.subject;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rut.miit.testingsystem.subject.dto.request.SubjectDto;
import rut.miit.testingsystem.subject.dto.response.FacultyDtoResponse;
import rut.miit.testingsystem.subject.dto.response.SubjectDtoResponse;
import rut.miit.testingsystem.subject.faculty.Faculty;

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
    public List<SubjectDtoResponse> findAll() {
        return service.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public SubjectDtoResponse findById(@PathVariable UUID id) {
        Subject subject = service.findById(id);
        return mapper.toDto(subject);
    }

    @GetMapping("/faculties")
    public List<SubjectDtoResponse> findByFaculty(@RequestParam Faculty faculty) {
        return service.findByFaculty(faculty).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        service.deleteById(id);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public SubjectDtoResponse create(@RequestBody @Valid SubjectDto createRequest) {
        Subject subject = mapper.toEntity(createRequest);
        subject = service.create(subject);
        return mapper.toDto(subject);
    }

    @GetMapping("/faculties/")
    public List<FacultyDtoResponse> getFaculties() {
        return Faculty.stream().
                map(FacultyDtoResponse::of)
                .collect(Collectors.toList());
    }
}
