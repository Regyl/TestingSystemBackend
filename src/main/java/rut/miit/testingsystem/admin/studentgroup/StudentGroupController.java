package rut.miit.testingsystem.admin.studentgroup;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rut.miit.testingsystem.admin.studentgroup.dto.request.StudentGroupDTOCreateRequest;
import rut.miit.testingsystem.admin.studentgroup.dto.response.StudentGroupDTOCreateResponse;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/students/groups")
public class StudentGroupController implements IStudentGroupController {
    StudentGroupService service;
    public StudentGroupController(StudentGroupService service) {
        this.service=service;
    }

    @PostMapping("/")
    public ResponseEntity<StudentGroupDTOCreateResponse> create(@RequestBody @Valid StudentGroupDTOCreateRequest createRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new StudentGroupDTOCreateResponse(service.save(createRequest)));
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentGroup> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentGroup findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable UUID id) {
        service.deleteById(id);
    }
}
