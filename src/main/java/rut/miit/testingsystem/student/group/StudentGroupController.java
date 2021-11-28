package rut.miit.testingsystem.student.group;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rut.miit.testingsystem.student.group.dto.request.StudentGroupDTOCreateRequest;
import rut.miit.testingsystem.student.group.dto.response.StudentGroupDTOCreateResponse;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Tag(name = "Student groups")

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
    public List<StudentGroup> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    
    public StudentGroup findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    
    public void deleteById(@PathVariable UUID id) {
        service.deleteById(id);
    }
}
