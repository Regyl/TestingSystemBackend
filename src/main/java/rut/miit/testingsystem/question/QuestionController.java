package rut.miit.testingsystem.question;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rut.miit.testingsystem.question.dto.request.QuestionDTOCreateRequest;
import rut.miit.testingsystem.question.dto.response.QuestionDTOCreateResponse;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/questions")
public class QuestionController implements IQuestionController {
    final QuestionService service;
    public QuestionController(QuestionService service) {
        this.service=service;
    }

    @GetMapping("/")
    public List<Question> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Question findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        service.deleteById(id);
    }

    @PostMapping("/")
    public ResponseEntity<QuestionDTOCreateResponse> create(@RequestBody @Valid QuestionDTOCreateRequest createRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new QuestionDTOCreateResponse(service.create(createRequest)));
    }
}
