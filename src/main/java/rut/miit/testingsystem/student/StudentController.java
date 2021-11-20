package rut.miit.testingsystem.student;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rut.miit.testingsystem.student.dto.request.StudentDTOCreateRequest;
import rut.miit.testingsystem.student.dto.request.StudentDTOGroupUpdateRequest;
import rut.miit.testingsystem.student.dto.response.StudentDTOCreateResponse;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/students")
public class StudentController implements IStudentController {
    private final StudentService service;
    public StudentController(StudentService service) {
        this.service=service;
    }

    @GetMapping("/")
    public List<Student> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<StudentDTOCreateResponse> create(@RequestBody @Valid StudentDTOCreateRequest createRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new StudentDTOCreateResponse(service.create(createRequest)));
    }

    @PutMapping("/")
    @Operation(summary = "Update user info after registration")
    public void postCreate(@RequestParam UUID studentId) {
        service.updateStatus(studentId);
    }

    @GetMapping("/emptygroup")
    @Operation(summary = "Returns all students without group")
    public List<Student> findStudentsWithoutGroup() {
        return service.findByGroupIdIsNull();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        service.deleteById(id);
    }

    @PutMapping("/updategroup")
    @Operation(summary = "Add to student any group")
    public void updateStudentsGroup(@RequestBody @Valid StudentDTOGroupUpdateRequest groupUpdateRequest) {
        service.updateGroup(groupUpdateRequest);
    }
}
