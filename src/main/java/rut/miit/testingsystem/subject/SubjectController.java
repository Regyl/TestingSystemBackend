package rut.miit.testingsystem.subject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rut.miit.testingsystem.subject.dto.request.SubjectDTOCreateRequest;
import rut.miit.testingsystem.subject.dto.response.SubjectDTOCreateResponse;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/subjects")
public class SubjectController implements ISubjectController {
    final SubjectService service;
    public SubjectController(SubjectService service) {
        this.service=service;
    }

    @GetMapping("/")
    public List<Subject> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Subject findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        service.deleteById(id);
    }

    @PostMapping("/")
    public ResponseEntity<SubjectDTOCreateResponse> create(@RequestBody @Valid SubjectDTOCreateRequest createRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new SubjectDTOCreateResponse(service.create(createRequest)));
    }
}
