package rut.miit.testingsystem.subject.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class SubjectDTOCreateRequest {
    @NotNull
    private String name;
}
