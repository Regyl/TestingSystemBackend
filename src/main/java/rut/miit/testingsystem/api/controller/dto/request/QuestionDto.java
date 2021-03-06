package rut.miit.testingsystem.api.controller.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class QuestionDto {
    @NotNull
    private String text;

    private String additionalInfo;

    @NotNull
    private UUID testId;
}
