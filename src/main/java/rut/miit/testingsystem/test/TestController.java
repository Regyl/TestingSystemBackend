package rut.miit.testingsystem.test;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rut.miit.testingsystem.test.dto.request.TestDTOCreateRequest;
import rut.miit.testingsystem.test.dto.response.TestDTOCreateResponse;

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
