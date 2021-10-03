package rut.miit.testingsystem.student;

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
    StudentService service;
    public StudentController(StudentService service) {
        this.service=service;
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Student findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PostMapping("/")
    public ResponseEntity<StudentDTOCreateResponse> create(@RequestBody @Valid StudentDTOCreateRequest createRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new StudentDTOCreateResponse(service.create(createRequest)));
    }

    @PutMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public void postCreate(@RequestParam UUID studentId) {
        service.updateStatus(studentId);
    }

    @GetMapping("/withoutGroup")
    public List<Student> findStudentsWithoutGroup() {
        return service.findByGroupIdIsNull();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable UUID id) {
        service.deleteById(id);
    }

    @PutMapping("/addGroup")
    @ResponseStatus(HttpStatus.OK)
    public void updateStudentsGroup(@RequestBody @Valid StudentDTOGroupUpdateRequest groupUpdateRequest) {
        service.updateGroup(groupUpdateRequest);
    }
}
