package rut.miit.testingsystem.test.answer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rut.miit.testingsystem.test.answer.dto.request.AnswerDTOCreateRequest;
import rut.miit.testingsystem.test.answer.dto.response.AnswerDTOCreateResponse;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/answers")
public class AnswerController implements IAnswerController {
    final AnswerService service;
    public AnswerController(AnswerService service) {
        this.service=service;
    }

    @GetMapping("/{id}")
    public Answer findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @GetMapping("/")
    public List<Answer> findAll() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        service.deleteById(id);
    }

    @PostMapping("/")
    public ResponseEntity<AnswerDTOCreateResponse> create(@RequestBody @Valid AnswerDTOCreateRequest createRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new AnswerDTOCreateResponse(service.create(createRequest)));
    }
}
