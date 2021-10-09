package rut.miit.testingsystem.student.result;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/students/results")
public class StudentResultController implements IStudentResultController {
    final StudentResultService service;
    public StudentResultController(StudentResultService service) {
        this.service=service;
    }

    @GetMapping("/")
    public List<StudentResult> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public StudentResult findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        //TODO:
    }


}
