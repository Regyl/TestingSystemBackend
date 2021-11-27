package rut.miit.testingsystem.subject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rut.miit.testingsystem.subject.dto.request.SubjectDTOCreateRequest;
import rut.miit.testingsystem.subject.dto.response.FacultyDtoResponse;
import rut.miit.testingsystem.subject.dto.response.SubjectDTOResponse;
import rut.miit.testingsystem.subject.faculty.Faculty;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/subjects")
public class SubjectController implements ISubjectController {
    private final SubjectService service;

    public SubjectController(SubjectService service) {
        this.service=service;
    }

    @GetMapping("/")
    public List<SubjectDTOResponse> findAll() {
        return service.findAll().stream()
                .map(SubjectDTOResponse::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public SubjectDTOResponse findById(@PathVariable UUID id) {
        Subject subject = service.findById(id);
        return new SubjectDTOResponse(subject);
    }

    @GetMapping("/faculties")
    public List<SubjectDTOResponse> findByFaculty(@RequestParam Faculty faculty) {
        return service.findByFaculty(faculty).stream()
                .map(SubjectDTOResponse::new)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        service.deleteById(id);
    }

    @PostMapping("/")
    public ResponseEntity<SubjectDTOResponse> create(@RequestBody @Valid SubjectDTOCreateRequest createRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new SubjectDTOResponse(service.create(createRequest)));
    }

    @GetMapping("/faculties/")
    public List<FacultyDtoResponse> getFaculties() {
        return Faculty.stream().
                map(FacultyDtoResponse::of)
                .collect(Collectors.toList());
    }
}
