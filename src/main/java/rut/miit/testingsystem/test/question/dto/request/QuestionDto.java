package rut.miit.testingsystem.test.question.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@NoArgsConstructor
public class QuestionDto {
    @NotNull
    private String text;

    private String additionalInfo;

    @NotNull
    private UUID testId;
}
