package rut.miit.testingsystem.professor.test;

import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rut.miit.testingsystem.professor.test.dto.request.TestDTOCreateRequest;
import rut.miit.testingsystem.professor.test.dto.response.TestDTOCreateResponse;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tests")
public class TestController implements ITestController {
    final TestService service;
    public TestController(TestService service) {
        this.service=service;
    }

    @GetMapping("/")
    public List<Test> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Test findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        service.deleteById(id);
    }

    @PostMapping("/")
    public ResponseEntity<TestDTOCreateResponse> create(@RequestBody @Valid TestDTOCreateRequest createRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new TestDTOCreateResponse(service.create(createRequest)));
    }
}
